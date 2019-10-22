package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    //@GetMapping("/{mypath}")
    @GetMapping("/doshka")
    public String first(
            //@PathVariable("mypath") String path,
            @RequestParam(required = false, name = "doshka") int doshka,
            @RequestParam(required = false, name = "srakadoshka") String srakadoshka)
    {
        List<String> list = getList();
        if (doshka < 0 || doshka > list.size()-1)return "Дебіл бля, ти сука йобаний хуй не можеш навіть число вказати, хуйло їбане!!" + HttpStatus.BAD_REQUEST;
        list.set(doshka, "chotka sraka");
        if (srakadoshka == null)srakadoshka = "base";
        return srakadoshka + "\n" + list + HttpStatus.OK;
    }

    public List<String> getList(){
        List <String> list = new ArrayList<>();
        list.add("sraka");
        list.add("pizdec");
        list.add("ibav");
        return list;
    }
}
