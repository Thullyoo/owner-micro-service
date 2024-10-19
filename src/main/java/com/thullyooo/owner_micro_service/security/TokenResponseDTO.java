package com.thullyooo.owner_micro_service.security;

public record TokenResponseDTO(String token, Long expiresAt) {
}
