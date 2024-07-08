package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.PermissionCreateDto;
import com.StajProje.Company.dto.PermissionDto;
import com.StajProje.Company.dto.PermissionUpdateDto;
import com.StajProje.Company.mapper.PermissionMapper;
import com.StajProje.Company.repository.PermissionRepository;
import com.StajProje.Company.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionDto addPermission(PermissionCreateDto permissionCreateDto) {
        return null;
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
