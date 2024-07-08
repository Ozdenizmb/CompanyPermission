package com.StajProje.Company.service;

import com.StajProje.Company.dto.PermissionCreateDto;
import com.StajProje.Company.dto.PermissionDto;
import com.StajProje.Company.dto.PermissionUpdateDto;

import java.util.List;
import java.util.UUID;

public interface PermissionService {

    PermissionDto addPermission(PermissionCreateDto permissionCreateDto);
    PermissionDto getPermission(UUID id);
    List<PermissionDto> getPermissionsForEmployee(UUID employeeId);
    PermissionDto updatePermission(UUID id, PermissionUpdateDto permissionUpdateDto);
    Boolean deletePermission(UUID id);
    Boolean deletePermissionsForEmployee(UUID employeeId);

}
