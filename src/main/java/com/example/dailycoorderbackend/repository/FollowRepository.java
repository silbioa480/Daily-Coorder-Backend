package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
