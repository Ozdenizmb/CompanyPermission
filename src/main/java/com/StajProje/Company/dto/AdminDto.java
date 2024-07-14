package com.StajProje.Company.dto;

import java.util.UUID;

public record AdminDto(
        UUID id,
        String email,
        String role
) {
}
