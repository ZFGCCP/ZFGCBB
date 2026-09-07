package com.zfgc.zfgbb.model.users;

import java.time.OffsetDateTime;

public record ConsumedRefreshToken(Integer userId, boolean stayLoggedIn, OffsetDateTime issuedTs, String familyId,
		Integer parentTokenId, String existingSuccessorRaw) {
}
