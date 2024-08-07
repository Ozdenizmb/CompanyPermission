package com.StajProje.Company.repository;

import com.StajProje.Company.model.PropertiesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertiesDataRepository extends JpaRepository<PropertiesData, UUID> {



}
