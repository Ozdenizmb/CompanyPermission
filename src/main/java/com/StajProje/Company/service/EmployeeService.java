package com.StajProje.Company.service;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    UUID signUpEmployee(EmployeeCreateDto employeeCreateDto);
    EmployeeDto loginEmployee(String email, String password);
    EmployeeDto getEmployee(String email);
    EmployeeDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto, MultipartFile file);
    Boolean deleteEmployee(UUID id);
    List<EmployeeDto> getAllEmployees();

}
