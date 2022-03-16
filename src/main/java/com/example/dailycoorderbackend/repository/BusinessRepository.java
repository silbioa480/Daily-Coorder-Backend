package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessRepository extends JpaRepository<Business, String> {
    @Query("select business_name from Business")
    Business findTop10OrderByBusinessNameDesc(@Param("business_name") String business_name);
}
