package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    private String authNickname = null;

    @GetMapping("/allusers")
    public String index(Map<String, Object> model){
        List<UserEntity> user = userService.findAllUsers();
        model.put("users", user);
        return "allusers";
    }
}
