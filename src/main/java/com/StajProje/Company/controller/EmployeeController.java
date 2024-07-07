package com.StajProje.Company.controller;

import com.StajProje.Company.api.EmployeeApi;
import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class EmployeeController implements EmployeeApi {

    private final EmployeeService service;

    @Override
    public ResponseEntity<UUID> createEmployee(EmployeeCreateDto employeeCreateDto) {
        return ResponseEntity.ok(service.createEmployee(employeeCreateDto));
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployee(String email) {
        return ResponseEntity.ok(service.getEmployee(email));
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto) {
        return ResponseEntity.ok(service.updateEmployee(email, employeeUpdateDto));
    }
}
