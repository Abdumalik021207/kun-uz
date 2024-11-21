package org.example.kunuz.repository;

import org.example.kunuz.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
