package com.StajProje.Company.mapper;

import com.StajProje.Company.dto.EmployeeDto;
import com.StajProje.Company.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {



}
