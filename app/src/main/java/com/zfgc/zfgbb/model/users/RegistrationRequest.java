package com.zfgc.zfgbb.model.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
		@NotBlank @Size(min = 3, max = 50) String userName,
		@NotBlank @Size(min = 3, max = 50) String displayName,
		@NotBlank @Email String email,
		@NotBlank @Size(min = 8, max = 100) String password) {
}
