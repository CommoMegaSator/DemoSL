package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main(){return "index";}

    @GetMapping("/allusers")
    public String index(Map<String, Object> model){
        List<UserEntity> user = userService.findAllUsers();
        model.put("users", user);
        return "allusers";//new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password){
        System.out.println(email + "\n" + password + "\n");
        UserEntity userEntity = userService.findByEmail(email);
        System.out.println(userEntity.getEmail() + "\n" + userEntity.getPassword() + "\n");
        if (userEntity != null && userEntity.getPassword().equals(password))return "index";
        else return "registration";
    }

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") UserEntity userEntity){
        userService.saveUser(userEntity);
        return "redirect:/allusers";
    }

}
