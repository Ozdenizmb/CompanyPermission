package com.StajProje.Company.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmployeeUpdateDto(
        @NotBlank
        @NotNull
        String firstName,
        @NotBlank
        @NotNull
        String lastName,
        @NotBlank
        @NotNull
        String password,
        String biography,
        String phoneNumber,
        String department,
        LocalDate birthday
) {
}
