package com.StajProje.Company.repository;

import com.StajProje.Company.model.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, UUID> {

    List<Permission> findByEmail(String email);
    Page<Permission> findAllByEmail(String email, Pageable pageable);

}
