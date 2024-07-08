package com.StajProje.Company.mapper;

import com.StajProje.Company.dto.PermissionDto;
import com.StajProje.Company.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDto> {



}
