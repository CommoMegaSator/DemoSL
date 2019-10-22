package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> saveUser(UserEntity userEntity);

    UserEntity findUserByNickname(String username);

    UserEntity findByEmail(String email);

    List<UserEntity> findAllUsers();

    UserEntity updateUserById(Long id, UserEntity userToUpdate);
}
