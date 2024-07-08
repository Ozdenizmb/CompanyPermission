package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.PermissionCreateDto;
import com.StajProje.Company.dto.PermissionDto;
import com.StajProje.Company.dto.PermissionUpdateDto;
import com.StajProje.Company.exception.ErrorMessages;
import com.StajProje.Company.exception.PermissionException;
import com.StajProje.Company.mapper.PermissionMapper;
import com.StajProje.Company.model.Employee;
import com.StajProje.Company.model.Permission;
import com.StajProje.Company.repository.EmployeeRepository;
import com.StajProje.Company.repository.PermissionRepository;
import com.StajProje.Company.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final EmployeeRepository employeeRepository;
    private final PermissionMapper mapper;

    @Override
    public PermissionDto addPermission(PermissionCreateDto permissionCreateDto) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionCreateDto, permission);
        int numberOfPermissionDay = (int)ChronoUnit.DAYS.between(permissionCreateDto.startDate(), permissionCreateDto.endDate());

        Optional<Employee> responseEmployee = employeeRepository.findById(permissionCreateDto.employeeId());

        if(responseEmployee.isPresent()) {
            Employee existEmployee = responseEmployee.get();

            if(existEmployee.getLeaveBalance() - (numberOfPermissionDay+1) >= 0) {
                permission.setNumberOfDays(numberOfPermissionDay+1);
                Permission response = permissionRepository.save(permission);
                existEmployee.setLeaveBalance(existEmployee.getLeaveBalance() - (numberOfPermissionDay+1));
                employeeRepository.save(existEmployee);

                return mapper.toDto(response);
            }
            else {
                throw PermissionException.withStatusAndMessage(HttpStatus.BAD_REQUEST, ErrorMessages.DONT_HAVE_ENOUGH_PERMISSION);
            }
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.EMPLOYEE_NOT_FOUND);
        }

    }

    @Override
    public PermissionDto getPermission(UUID id) {
        return null;
    }

    @Override
    public List<PermissionDto> getPermissionsForEmployee(UUID employeeId) {
        return List.of();
    }

    @Override
    public PermissionDto updatePermission(UUID id, PermissionUpdateDto permissionUpdateDto) {
        return null;
    }

    @Override
    public Boolean deletePermission(UUID id) {
        return null;
    }

    @Override
    public Boolean deletePermissionsForEmployee(UUID employeeId) {
        return null;
    }

}
