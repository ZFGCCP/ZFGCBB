package com.zfgc.zfgbb.dataprovider.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dbo.BoardPermissionViewDbo;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dao.forum.BoardPermissionViewDao;
import com.zfgc.zfgbb.model.users.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class GuestPermissionDataProvider {

	private final BoardPermissionViewDao boardPermissionViewDao;

	@Cacheable("guestVisibleBoardIds")
	public List<Integer> guestVisibleBoardIds() {
		BoardPermissionViewDboExample ex = new BoardPermissionViewDboExample();
		ex.createCriteria().andPermissionIdIn(User.guest().permissionIds());
		return boardPermissionViewDao.get(ex).stream()
				.map(BoardPermissionViewDbo::getBoardId).distinct().collect(Collectors.toList());
	}
}
