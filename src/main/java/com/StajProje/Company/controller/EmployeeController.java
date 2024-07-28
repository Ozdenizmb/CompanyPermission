package com.StajProje.Company.controller;

import com.StajProje.Company.api.EmployeeApi;
import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class EmployeeController implements EmployeeApi {

    private final EmployeeService service;

    @Override
    public ResponseEntity<UUID> signUpEmployee(EmployeeCreateDto employeeCreateDto) {
        return ResponseEntity.ok(service.signUpEmployee(employeeCreateDto));
    }

    @Override
    public ResponseEntity<EmployeeDto> loginEmployee(String email, String password) {
        return ResponseEntity.ok(service.loginEmployee(email, password));
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployee(String email) {
        return ResponseEntity.ok(service.getEmployee(email));
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto) {
        return ResponseEntity.ok(service.updateEmployee(id, employeeUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteEmployee(UUID id) {
        return ResponseEntity.ok(service.deleteEmployee(id));
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
