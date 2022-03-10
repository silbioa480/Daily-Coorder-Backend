package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Board, Long> {
}
