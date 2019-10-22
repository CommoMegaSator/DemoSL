package com.example.demo.service.impl;

import com.example.demo.entity.ArticlesEntity;
import com.example.demo.repository.ArticlesRepository;
import com.example.demo.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public void createArticle(ArticlesEntity articlesEntity) {
        articlesRepository.save(articlesEntity);
    }

    @Override
    public List<ArticlesEntity> findAllArticles() {
        return articlesRepository.findAll();
    }

}
