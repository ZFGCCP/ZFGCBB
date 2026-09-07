package com.zfgc.zfgbb.model.users;

public record AccountDeletionRequest(String mode, String password, String confirmationPhrase) {
}
