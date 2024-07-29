package com.example.newsaggregator.service;

import com.example.newsaggregator.model.Article;
import com.example.newsaggregator.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<Article> searchArticles(String query) {
        if (query == null || query.isEmpty()) {
            return getAllArticles();
        }
        return articleRepository.searchByTitleAndDescription(query, query);
    }

    public List<Article> searchArticlesByTitle(String titleKeyword) {
        if (titleKeyword == null || titleKeyword.isEmpty()) {
            return getAllArticles();
        }
        return articleRepository.searchByTitle(titleKeyword);
    }
}
