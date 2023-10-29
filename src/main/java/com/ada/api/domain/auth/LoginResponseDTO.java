package com.ada.api.domain.auth;

import java.util.UUID;

import com.ada.api.domain.person.UserRole;

public record LoginResponseDTO( UUID id, UserRole role, String token) {

}
