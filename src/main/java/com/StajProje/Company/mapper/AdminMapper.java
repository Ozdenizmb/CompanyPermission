package com.StajProje.Company.mapper;

import com.StajProje.Company.dto.AdminDto;
import com.StajProje.Company.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper extends BaseMapper<Admin, AdminDto> {



}
