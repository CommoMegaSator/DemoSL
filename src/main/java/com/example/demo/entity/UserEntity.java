package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "usr")
public class UserEntity extends BaseEntity{

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age")
    private int age;

    @Column(nullable = false, unique = true)
    private String email;

}
