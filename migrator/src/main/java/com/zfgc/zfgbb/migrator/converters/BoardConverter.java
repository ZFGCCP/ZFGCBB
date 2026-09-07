package com.zfgc.zfgbb.migrator.converters;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.web.util.HtmlUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.mappers.BoardDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.jobs.MigratorPermissionService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFBoardDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFBoardDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFBoardDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoardConverter extends AbstractConverter<Map<Integer, BoardDbo>> {

	private final SMFBoardDbMapper smfBoardMapper;

	private final BoardDboMapper boardMapper;

	private final MigratorIdMapService idMap;

	private final MigratorPermissionService permissions;

	@Override
	public JobType getType() {
		return JobType.BOARDS;
	}

	@Override
	@Transactional
	public Map<Integer, BoardDbo> convertToZfgbb() {
		List<SMFBoardDb> SMFBoards = smfBoardMapper.selectByExample(new SMFBoardDbExample());
		Map<Integer, BoardDbo> result = new HashMap<>();

		SMFBoards.forEach((smfBoard) -> {
			Cancellable.check();
			BoardDbo board = new BoardDbo();

			board.setBoardName(HtmlUtils.htmlUnescape(smfBoard.getName()));
			board.setCategoryId(idMap.lookup(LegacyEntityType.CATEGORY, smfBoard.getIdCat()));
			board.setSeqno(smfBoard.getBoardOrder().intValue());

			board.setMigrationHash(MigrationHasher.hash(smfBoard.getIdBoard().toString()
					+ board.getBoardName()
					+ (board.getDescription() == null ? "" : board.getDescription())
					+ (board.getCategoryId() == null ? "" : board.getCategoryId())
					+ board.getSeqno()
					+ (smfBoard.getIdParent() == null ? "" : smfBoard.getIdParent())));

			Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.BOARD, smfBoard.getIdBoard());
			if (existingZfgbbId == null) {
				boardMapper.insert(board);
				idMap.record(LegacyEntityType.BOARD, smfBoard.getIdBoard(), board.getBoardId());
			} else {
				BoardDbo existing = boardMapper.selectByPrimaryKey(existingZfgbbId);
				if (existing == null) {
					board.setBoardId(existingZfgbbId);
					boardMapper.insert(board);
				} else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), board.getMigrationHash())) {
					board.setBoardId(existingZfgbbId);
					boardMapper.updateByPrimaryKey(board);
				} else {
					board.setBoardId(existingZfgbbId);
				}
			}

			result.put(smfBoard.getIdBoard(), board);
		});

		// Second pass: set parent_board_id (now that all boards have ZFGBB ids)
		SMFBoards.forEach(smfBoard -> {
			BoardDbo board = result.get(smfBoard.getIdBoard());
			Integer smfParent = smfBoard.getIdParent();
			if (smfParent == null) {
				board.setParentBoardId(0);
				boardMapper.updateByPrimaryKey(board);
			} else if (smfParent != 0) {
				Integer parentZfgbbId = idMap.lookupOrNull(LegacyEntityType.BOARD, smfParent);
				if (parentZfgbbId != null) {
					board.setParentBoardId(parentZfgbbId);
					boardMapper.updateByPrimaryKey(board);
				}
			}
		});

		SMFBoards.forEach(smfBoard -> {
			BoardDbo board = result.get(smfBoard.getIdBoard());
			if (board == null) {
				return;
			}
			Set<String> codes = new LinkedHashSet<>(
					permissions.mapSmfGroupCsvToCodes(smfBoard.getMemberGroups()));
			codes.add(MigratorPermissionService.CODE_SITE_ADMIN);
			permissions.replaceBoardPermissions(board.getBoardId(), codes);
		});

		return result;
	}
}
