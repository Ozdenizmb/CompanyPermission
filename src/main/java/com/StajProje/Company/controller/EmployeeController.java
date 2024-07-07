package com.StajProje.Company.controller;

import com.StajProje.Company.api.EmployeeApi;
import com.StajProje.Company.dto.EmployeeCreateDto;
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
}
