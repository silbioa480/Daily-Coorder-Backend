package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
