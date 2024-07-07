package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.repository.EmployeeRepository;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Long createEmployee(EmployeeCreateDto employeeCreateDto) {
        return null;
    }

    @Override
    public EmployeeDto getEmployee(String email) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto) {
        return null;
    }

    @Override
    public Boolean deleteEmployee(String email) {
        return null;
    }
}
