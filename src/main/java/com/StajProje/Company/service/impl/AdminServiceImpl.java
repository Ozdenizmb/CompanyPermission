package com.StajProje.Company.service.impl;

import com.StajProje.Company.dto.AdminCreateDto;
import com.StajProje.Company.dto.AdminDto;
import com.StajProje.Company.dto.AdminUpdateDto;
import com.StajProje.Company.exception.ErrorMessages;
import com.StajProje.Company.exception.PermissionException;
import com.StajProje.Company.mapper.AdminMapper;
import com.StajProje.Company.model.Admin;
import com.StajProje.Company.repository.AdminRepository;
import com.StajProje.Company.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;
    private final AdminMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AdminDto signUpAdmin(AdminCreateDto adminCreateDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminCreateDto, admin);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        Admin response = repository.save(admin);

        return mapper.toDto(response);
    }

    @Override
    public List<AdminDto> getAdmins() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public AdminDto updateAdmin(String email, AdminUpdateDto adminUpdateDto) {
        Optional<Admin> responseAdmin = repository.findByEmail(email);

        if(responseAdmin.isEmpty()) {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ADMIN_NOT_FOUND);
        }

        Admin existAdmin = responseAdmin.get();
        BeanUtils.copyProperties(adminUpdateDto, existAdmin);
        existAdmin.setPassword(passwordEncoder.encode(existAdmin.getPassword()));

        return mapper.toDto(repository.save(existAdmin));
    }

    @Override
    public Boolean deleteAdmin(String email) {
        Optional<Admin> responseAdmin = repository.findByEmail(email);

        if(responseAdmin.isEmpty()) {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ADMIN_NOT_FOUND);
        }

        Admin existAdmin = responseAdmin.get();
        repository.delete(existAdmin);

        return true;
    }

}
