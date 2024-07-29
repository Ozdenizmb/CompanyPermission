package com.StajProje.Company.model;

import com.StajProje.Company.model.base.BaseEntity;
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
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "role")
    private String role;
    @Column(name = "statuses")
    private String statuses;

}
