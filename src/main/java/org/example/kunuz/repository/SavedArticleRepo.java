package org.example.kunuz.repository;

import org.example.kunuz.model.SavedArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedArticleRepo extends JpaRepository<SavedArticle, Long> {
}
