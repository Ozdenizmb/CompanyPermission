package com.StajProje.Company.controller;

import com.StajProje.Company.api.EmployeeApi;
import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<EmployeeDto> getEmployeeWithEmail(String email) {
        return ResponseEntity.ok(service.getEmployeeWithEmail(email));
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeWithId(UUID id) {
        return ResponseEntity.ok(service.getEmployeeWithId(id));
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto, MultipartFile file) {
        return ResponseEntity.ok(service.updateEmployee(id, employeeUpdateDto, file));
    }

    @Override
    public ResponseEntity<Boolean> deleteEmployee(UUID id) {
        return ResponseEntity.ok(service.deleteEmployee(id));
    }

    @Override
    public ResponseEntity<Page<EmployeeDto>> getAllEmployees(Pageable pageable) {
        return ResponseEntity.ok(service.getAllEmployees(pageable));
    }
}
