package com.example.demo.controller;

import com.example.demo.entity.ArticlesEntity;
import com.example.demo.service.ArticlesService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ArticlesEntity article){
        articlesService.createArticle(article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> showArticles(){
        return ResponseEntity.ok(articlesService.findAllArticles());
        //return new ResponseEntity<>(articlesService.findAllArticles(), HttpStatus.OK);
    }
}
