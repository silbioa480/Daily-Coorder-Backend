package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
}
