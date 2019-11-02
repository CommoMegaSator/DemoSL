package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return null;
    }

    public UserEntity findByEmail(String email){return userRepository.findByEmail(email);}

    @Override
    public UserEntity findUserByNickname(String username) {
        UserEntity userEntity = userRepository.findUserByNickname(username);
        return userEntity;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities;
    }

    public UserEntity updateUserById(Long id, UserEntity userToUpdate){
        boolean exists = userRepository.existsById(id);
        boolean existsByEmail = userRepository.existsByEmail(userToUpdate.getEmail());
        if(!exists || existsByEmail)return null;
        UserEntity userFromDb = userRepository.findById(id).get();
        userFromDb.setFirstname(userToUpdate.getFirstname());
        userFromDb.setLastname(userToUpdate.getLastname());
        userFromDb.setNickname(userToUpdate.getNickname());
        userFromDb.setEmail(userToUpdate.getEmail());
        userFromDb.setAge(userToUpdate.getAge());
        userFromDb.setPassword(userToUpdate.getPassword());
        userRepository.save(userFromDb);
        return userFromDb;
    }
public void deleteById(Long id){
        userRepository.deleteById(id);
}
}
