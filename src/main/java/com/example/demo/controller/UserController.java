package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    private String authNickname = null;

    @GetMapping("/")
    public String main(){return "index";}

    @GetMapping("/allusers")
    public String index(Map<String, Object> model){
        List<UserEntity> user = userService.findAllUsers();
        model.put("users", user);
        return "allusers";
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
        userService.saveUser(userEntity);
        return "redirect:/allusers";
    }

    @GetMapping("/profile")
    public String getProfile(Map<String, Object> model){
        if (authNickname!=null) {
            UserEntity userEntity = userService.findUserByNickname(authNickname);
            model.put("user", userEntity);
            return "profile";
        }
        else return "redirect:/login";
    }

    @GetMapping("/errorPage")
    public String getError(){return "errorPage";}

    @GetMapping("/logout")
    public String logOut(){
        authNickname = null;
        return "redirect:/login";
    }
}
