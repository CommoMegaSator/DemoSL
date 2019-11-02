package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserByNickname(String nickname);
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(Long id);
}
