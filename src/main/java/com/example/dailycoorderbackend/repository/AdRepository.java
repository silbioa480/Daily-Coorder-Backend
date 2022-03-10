package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.AdTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<AdTable, Long> {
}
