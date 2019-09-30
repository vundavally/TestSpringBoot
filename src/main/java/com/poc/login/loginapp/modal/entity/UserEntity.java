package com.poc.login.loginapp.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="users")
@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    private String username;
    private String password;
    private String role;
}
