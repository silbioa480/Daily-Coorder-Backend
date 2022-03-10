package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
