package com.example.newsaggregator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsaggregator.model.Article;
import com.example.newsaggregator.service.ArticleService;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/news")
    public List<Article> getAllNews() {
        return articleService.getAllArticles();
    }

    @GetMapping("/api/news/search")
    public List<Article> searchNews(@RequestParam(required = false) String query, @RequestParam(required = false) String title) {
        if (query != null && !query.isEmpty()) {
            return articleService.searchArticles(query);
        }
        if (title != null && !title.isEmpty()) {
            return articleService.searchArticlesByTitle(title);
        }
        return articleService.getAllArticles();
    }
}

