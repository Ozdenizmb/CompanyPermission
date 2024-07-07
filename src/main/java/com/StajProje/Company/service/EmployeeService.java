package com.StajProje.Company.service;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;

public interface EmployeeService {

    Long createEmployee(EmployeeCreateDto employeeCreateDto);
    EmployeeDto getEmployee(String email);
    EmployeeDto updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto);
    Boolean deleteEmployee(String email);

}
