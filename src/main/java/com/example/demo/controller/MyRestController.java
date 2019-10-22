package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    @Autowired
    UserService userService;

    @RequestMapping("/email/{email}")
    public ResponseEntity<?> rest(@PathVariable String email){
        UserEntity userEntity = userService.findByEmail(email);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getByUserName(@RequestParam(required = false, name = "nickname") String nickname){
        UserEntity userEntity = userService.findUserByNickname(nickname);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @PutMapping("/new/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long id, @RequestBody UserEntity userEntity){
        UserEntity user = userService.updateUserById(id, userEntity);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
