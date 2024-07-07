package com.StajProje.Company.dto;

public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String department,
        int leaveBalance
) {
}
