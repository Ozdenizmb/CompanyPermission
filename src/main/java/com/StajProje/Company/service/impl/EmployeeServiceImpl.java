package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.mapper.EmployeeMapper;
import com.StajProje.Company.model.Employee;
import com.StajProje.Company.repository.EmployeeRepository;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public UUID createEmployee(EmployeeCreateDto employeeCreateDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeCreateDto, employee);
        employee.setLeaveBalance(15);

        Employee response = employeeRepository.save(employee);

        return response.getId();
    }

    @Override
    public EmployeeDto getEmployee(String email) {
        Employee existEmployee = employeeRepository.findByEmail(email);
        return employeeMapper.toDto(existEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto) {
        Employee existEmployee = employeeRepository.findByEmail(email);
        BeanUtils.copyProperties(employeeUpdateDto, existEmployee);

        Employee response = employeeRepository.save(existEmployee);

        return employeeMapper.toDto(response);
    }

    @Override
    public Boolean deleteEmployee(String email) {
        return null;
    }
}
