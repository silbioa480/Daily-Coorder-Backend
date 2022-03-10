package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessProfileRepository extends JpaRepository <BusinessProfile, Long> {

}
