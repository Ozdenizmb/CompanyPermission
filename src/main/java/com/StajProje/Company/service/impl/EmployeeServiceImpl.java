package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.exception.ErrorMessages;
import com.StajProje.Company.exception.PermissionException;
import com.StajProje.Company.mapper.EmployeeMapper;
import com.StajProje.Company.model.Employee;
import com.StajProje.Company.repository.EmployeeRepository;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
        Optional<Employee> existEmployee = employeeRepository.findByEmail(email);

        if(existEmployee.isEmpty()) {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

        return employeeMapper.toDto(existEmployee.get());
    }

    @Override
    public EmployeeDto updateEmployee(String email, EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> existResponse = employeeRepository.findByEmail(email);

        if(existResponse.isPresent()) {
            Employee existEmployee = existResponse.get();
            BeanUtils.copyProperties(employeeUpdateDto, existEmployee);

            Employee response = employeeRepository.save(existEmployee);

            return employeeMapper.toDto(response);
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

    }

    @Override
    public Boolean deleteEmployee(String email) {
        Optional<Employee> existResponse = employeeRepository.findByEmail(email);

        if(existResponse.isEmpty()) {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

        Employee existEmployee = existResponse.get();
        employeeRepository.delete(existEmployee);

        return true;
    }
}
