package com.StajProje.Company.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Table(name = "admin_data", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

}
