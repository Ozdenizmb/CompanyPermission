package com.StajProje.Company.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PermissionCreateDto(
        UUID employeeId,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}
