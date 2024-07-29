package com.example.newsaggregator.repository;

import com.example.newsaggregator.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
    List<Article> findByTitleContainingIgnoreCase(String keyword);
    
    List<Article> findByDescriptionContainingIgnoreCase(String keyword);
    
    @Query("SELECT a FROM Article a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Article> searchByTitle(@Param("keyword") String keyword);
    
    @Query("SELECT a FROM Article a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :titleKeyword, '%')) AND LOWER(a.description) LIKE LOWER(CONCAT('%', :descriptionKeyword, '%'))")
    List<Article> searchByTitleAndDescription(@Param("titleKeyword") String titleKeyword, @Param("descriptionKeyword") String descriptionKeyword);
}

