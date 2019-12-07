package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    private String authNickname = null;

    @GetMapping("/profile")
    public String getProfile(Map<String, Object> model){
        if (authNickname!=null) {
            UserEntity userEntity = userService.findUserByNickname(authNickname);
            model.put("user", userEntity);
            return "profile";
        }
        else return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(){
        if (authNickname == null)return "login";
        else return "redirect:/profile";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nickname") String nickname, @RequestParam("password") String password){
        UserEntity userEntity = userService.findUserByNickname(nickname);

        try{
            if (userEntity != null && userEntity.getPassword().equals(password)){
                this.authNickname = nickname;
                return "redirect:/profile";
            }
            else return "redirect:/errorPage";
        }catch (Exception ex){return "redirect:/errorPage";}
    }

    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") UserEntity userEntity){
        if (isUserExists(userEntity))return "redirect:/errorPage";
        else{
            userService.saveUser(userEntity);
            return "redirect:/allusers";
        }
    }

    public boolean isUserExists(UserEntity userEntity){
        for(UserEntity user : userService.findAllUsers()){
            if (user.getEmail().equals(userEntity.getEmail()) || user.getNickname().equals(userEntity.getNickname()))return true;
        }return false;
    }

    @GetMapping("/logout")
    public String logOut(){
        authNickname = null;
        return "redirect:/login";
    }
}
