package com.StajProje.Company.service;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface EmployeeService {

    UUID signUpEmployee(EmployeeCreateDto employeeCreateDto);
    EmployeeDto loginEmployee(String email, String password);
    EmployeeDto getEmployeeWithEmail(String email);
    EmployeeDto getEmployeeWithId(UUID id);
    EmployeeDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto, MultipartFile file);
    Boolean deleteEmployee(UUID id);
    Page<EmployeeDto> getAllEmployees(Pageable pageable);

}
