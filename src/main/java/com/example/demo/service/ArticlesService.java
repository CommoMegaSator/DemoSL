package com.example.demo.service;

import com.example.demo.entity.ArticlesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticlesService {

    void createArticle(ArticlesEntity articlesEntity);

    List<ArticlesEntity> findAllArticles();
}
