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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@PropertySource("classpath:config.properties")
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;
    private final AdminMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${adminSignUpKey}")
    private String adminKey;

    @Override
    public AdminDto signUpAdmin(String key, AdminCreateDto adminCreateDto) {
        if(adminKey.equals(key)) {
            Admin admin = new Admin();
            BeanUtils.copyProperties(adminCreateDto, admin);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));

            Admin response = repository.save(admin);

            return mapper.toDto(response);
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.WRONG_ADMIN_KEY);
        }

    }

    @Override
    public AdminDto loginAdmin(String key, String email, String password) {
        if(adminKey.equals(key)) {
            Optional<Admin> admin = repository.findByEmail(email);

            if (admin.isPresent()) {
                Admin existAdmin = admin.get();

                if (passwordEncoder.matches(password, existAdmin.getPassword())) {
                    return mapper.toDto(existAdmin);
                }
                else {
                    throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.INCORRECT_LOGIN);
                }
            }
            else {
                throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ADMIN_NOT_FOUND);
            }
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.WRONG_ADMIN_KEY);
        }
    }

    @Override
    public List<AdminDto> getAdmins() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public AdminDto updateAdmin(String key, String email, AdminUpdateDto adminUpdateDto) {
        if(adminKey.equals(key)) {
            Optional<Admin> responseAdmin = repository.findByEmail(email);

            if(responseAdmin.isEmpty()) {
                throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ADMIN_NOT_FOUND);
            }

            Admin existAdmin = responseAdmin.get();
            BeanUtils.copyProperties(adminUpdateDto, existAdmin);
            existAdmin.setPassword(passwordEncoder.encode(existAdmin.getPassword()));

            return mapper.toDto(repository.save(existAdmin));
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.WRONG_ADMIN_KEY);
        }
    }

    @Override
    public Boolean deleteAdmin(String key, String email) {
        if(adminKey.equals(key)) {
            Optional<Admin> responseAdmin = repository.findByEmail(email);

            if(responseAdmin.isEmpty()) {
                throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.ADMIN_NOT_FOUND);
            }

            Admin existAdmin = responseAdmin.get();
            repository.delete(existAdmin);

            return true;
        }
        else {
            throw PermissionException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.WRONG_ADMIN_KEY);
        }
    }

}
