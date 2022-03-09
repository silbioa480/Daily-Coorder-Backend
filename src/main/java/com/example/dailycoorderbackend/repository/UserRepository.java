package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
