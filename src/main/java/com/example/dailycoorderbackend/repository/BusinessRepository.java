package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, String> {
}
