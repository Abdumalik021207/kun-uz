package org.example.kunuz.repository;

import org.example.kunuz.model.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepo extends JpaRepository<CommentLike, Long> {
}
