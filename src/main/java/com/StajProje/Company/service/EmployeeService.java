package com.StajProje.Company.service;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    UUID createEmployee(EmployeeCreateDto employeeCreateDto);
    EmployeeDto getEmployee(String email);
    EmployeeDto updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto);
    Boolean deleteEmployee(String email);
    List<EmployeeDto> getAllEmployees();

}
