package com.StajProje.Company.service;

import com.StajProje.Company.dto.AdminCreateDto;
import com.StajProje.Company.dto.AdminDto;
import com.StajProje.Company.dto.AdminUpdateDto;

import java.util.List;

public interface AdminService {

    AdminDto signUpAdmin(AdminCreateDto adminCreateDto);
    List<AdminDto> getAdmins();
    AdminDto updateAdmin(String email, AdminUpdateDto adminUpdateDto);
    Boolean deleteAdmin(String email);

}
