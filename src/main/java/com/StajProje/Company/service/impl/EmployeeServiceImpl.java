package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.EmployeeCreateDto;
import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.dto.EmployeeUpdateDto;
import com.StajProje.Company.exception.ErrorMessages;
import com.StajProje.Company.exception.PermissionException;
import com.StajProje.Company.mapper.EmployeeMapper;
import com.StajProje.Company.model.Employee;
import com.StajProje.Company.repository.EmployeeRepository;
import com.StajProje.Company.service.AuthService;
import com.StajProje.Company.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UUID signUpEmployee(EmployeeCreateDto employeeCreateDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeCreateDto, employee);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setLeaveBalance(15);

        Employee response = employeeRepository.save(employee);

        return response.getId();
    }

    @Override
    public EmployeeDto loginEmployee(String email, String password) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);

        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            if (passwordEncoder.matches(password, existingEmployee.getPassword())) {
                return employeeMapper.toDto(existingEmployee);
            }
            else {
                throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.INCORRECT_LOGIN);
            }
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }
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
    public EmployeeDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto) {
        if(!authService.verifyUserIdMatchesAuthenticatedUser(id)) {
            throw PermissionException.withStatusAndMessage(HttpStatus.FORBIDDEN, ErrorMessages.UNAUTHORIZED);
        }

        Optional<Employee> existResponse = employeeRepository.findById(id);

        if(existResponse.isPresent()) {
            Employee existEmployee = existResponse.get();
            BeanUtils.copyProperties(employeeUpdateDto, existEmployee);
            existEmployee.setPassword(passwordEncoder.encode(existEmployee.getPassword()));

            Employee response = employeeRepository.save(existEmployee);

            return employeeMapper.toDto(response);
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

    }

    @Override
    public Boolean deleteEmployee(UUID id) {
        if(!authService.verifyUserIdMatchesAuthenticatedUser(id)) {
            throw PermissionException.withStatusAndMessage(HttpStatus.FORBIDDEN, ErrorMessages.UNAUTHORIZED);
        }

        Optional<Employee> existResponse = employeeRepository.findById(id);

        if(existResponse.isEmpty()) {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

        Employee existEmployee = existResponse.get();
        employeeRepository.delete(existEmployee);

        return true;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> existEmployees = employeeRepository.findAll();
        return employeeMapper.toDtoList(existEmployees);
    }
}
