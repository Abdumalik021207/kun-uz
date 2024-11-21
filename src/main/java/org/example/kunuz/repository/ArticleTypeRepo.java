package org.example.kunuz.repository;

import org.example.kunuz.model.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTypeRepo extends JpaRepository<ArticleType, Long> {
}
