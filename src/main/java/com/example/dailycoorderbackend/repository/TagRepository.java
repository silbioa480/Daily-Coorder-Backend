package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
