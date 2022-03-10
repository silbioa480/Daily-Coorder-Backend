package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Board_likeRepository extends JpaRepository<Board, Long> {
}
