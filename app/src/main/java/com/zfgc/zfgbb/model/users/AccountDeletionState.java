package com.zfgc.zfgbb.model.users;

import java.time.OffsetDateTime;

public record AccountDeletionState(String status, String mode, OffsetDateTime expiresTs) {
}
