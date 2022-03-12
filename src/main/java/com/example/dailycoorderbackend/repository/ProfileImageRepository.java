package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
}
