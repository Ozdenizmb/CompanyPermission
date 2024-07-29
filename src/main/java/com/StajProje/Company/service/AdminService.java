package com.StajProje.Company.service;

import com.StajProje.Company.dto.AdminCreateDto;
import com.StajProje.Company.dto.AdminDto;
import com.StajProje.Company.dto.AdminUpdateDto;

import java.util.List;

public interface AdminService {

    AdminDto signUpAdmin(String key, AdminCreateDto adminCreateDto);
    AdminDto loginAdmin(String key, String email, String password);
    List<AdminDto> getAdmins();
    AdminDto updateAdmin(String key, String email, AdminUpdateDto adminUpdateDto);
    Boolean deleteAdmin(String key, String email);

}
