package com.erick.tourismsystem.dto;

public record AuthenticationRequest(
        String username,
        String password
) {
}
