package com.zfgc.zfgbb.migrator.jobs;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dbo.BrBoardPermissionDbo;
import com.zfgc.zfgbb.dbo.BrBoardPermissionDboExample;
import com.zfgc.zfgbb.dbo.BrUserPermissionDbo;
import com.zfgc.zfgbb.dbo.BrUserPermissionDboExample;
import com.zfgc.zfgbb.dbo.PermissionDbo;
import com.zfgc.zfgbb.dbo.PermissionDboExample;
import com.zfgc.zfgbb.mappers.BrBoardPermissionDboMapper;
import com.zfgc.zfgbb.mappers.BrUserPermissionDboMapper;
import com.zfgc.zfgbb.mappers.PermissionDboMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MigratorPermissionService {

	public static final List<String> DEFAULT_BOARD_PERMISSION_CODES =
			List.of("ZFGC_USER", "ZFGC_GUEST");

	public static final List<String> DEFAULT_USER_PERMISSION_CODES =
			List.of("ZFGC_USER");

	public static final String CODE_GUEST = "ZFGC_GUEST";
	public static final String CODE_USER = "ZFGC_USER";
	public static final String CODE_SITE_MODERATOR = "ZFGC_SITE_MODERATOR";
	public static final String CODE_SITE_ADMIN = "ZFGC_SITE_ADMIN";

	private final PermissionDboMapper permissionMapper;

	private final BrBoardPermissionDboMapper brBoardPermissionMapper;

	private final BrUserPermissionDboMapper brUserPermissionMapper;

	public Integer permissionIdByCode(String code) {
		PermissionDboExample ex = new PermissionDboExample();
		ex.createCriteria().andPermissionCodeEqualTo(code);
		List<PermissionDbo> matches = permissionMapper.selectByExample(ex);
		return matches.isEmpty() ? null : matches.get(0).getPermissionId();
	}

	public void grantBoardPermission(Integer boardId, String code) {
		Integer permissionId = permissionIdByCode(code);
		if (permissionId == null) {
			return;
		}
		BrBoardPermissionDboExample ex = new BrBoardPermissionDboExample();
		ex.createCriteria()
				.andBoardIdEqualTo(boardId)
				.andPermissionIdEqualTo(permissionId);
		if (brBoardPermissionMapper.countByExample(ex) > 0) {
			return;
		}
		BrBoardPermissionDbo row = new BrBoardPermissionDbo();
		row.setBoardId(boardId);
		row.setPermissionId(permissionId);
		brBoardPermissionMapper.insert(row);
	}

	public void grantDefaultBoardPermissions(Integer boardId) {
		DEFAULT_BOARD_PERMISSION_CODES.forEach(code -> grantBoardPermission(boardId, code));
	}

	public void replaceBoardPermissions(Integer boardId, Set<String> codes) {
		BrBoardPermissionDboExample clearEx = new BrBoardPermissionDboExample();
		clearEx.createCriteria().andBoardIdEqualTo(boardId);
		brBoardPermissionMapper.deleteByExample(clearEx);
		codes.forEach(code -> grantBoardPermission(boardId, code));
	}

	public void grantUserPermission(Integer userId, String code) {
		Integer permissionId = permissionIdByCode(code);
		if (permissionId == null) {
			return;
		}
		BrUserPermissionDboExample ex = new BrUserPermissionDboExample();
		ex.createCriteria()
				.andUserIdEqualTo(userId)
				.andUserPermissionIdEqualTo(permissionId);
		if (brUserPermissionMapper.countByExample(ex) > 0) {
			return;
		}
		BrUserPermissionDbo row = new BrUserPermissionDbo();
		row.setUserId(userId);
		row.setUserPermissionId(permissionId);
		brUserPermissionMapper.insert(row);
	}

	public void grantDefaultUserPermissions(Integer userId) {
		DEFAULT_USER_PERMISSION_CODES.forEach(code -> grantUserPermission(userId, code));
	}

	public void replaceUserPermissions(Integer userId, Set<String> codes) {
		BrUserPermissionDboExample clearEx = new BrUserPermissionDboExample();
		clearEx.createCriteria().andUserIdEqualTo(userId);
		brUserPermissionMapper.deleteByExample(clearEx);
		codes.forEach(code -> grantUserPermission(userId, code));
	}

	public Set<String> mapSmfGroupToCodes(Integer smfGroupId) {
		if (smfGroupId == null) {
			return Set.of();
		}
		switch (smfGroupId) {
			case -1:
				return Set.of(CODE_GUEST);
			case 0:
				return Set.of(CODE_USER);
			case 1:
				return Set.of(CODE_SITE_ADMIN);
			case 2:
			case 3:
				return Set.of(CODE_SITE_MODERATOR);
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				return Set.of(CODE_USER);
			default:
				// FIXME: custom SMF groups currently fall back to ZFGC_USER. Add real mapping support.
				return Set.of(CODE_USER);
		}
	}

	public Set<String> mapSmfGroupCsvToCodes(String csv) {
		Set<String> result = new LinkedHashSet<>();
		if (csv == null || csv.isBlank()) {
			return result;
		}
		Arrays.stream(csv.split(","))
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.forEach(token -> {
					try {
						result.addAll(mapSmfGroupToCodes(Integer.parseInt(token)));
					} catch (NumberFormatException ignore) {}
				});
		return result;
	}
}
