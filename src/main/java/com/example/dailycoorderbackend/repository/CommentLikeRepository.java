package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
}
