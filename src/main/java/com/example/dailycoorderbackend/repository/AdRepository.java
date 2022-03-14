package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdRepository extends JpaRepository<Ad, Long> {
  @Query("select a from Ad a where a.business_id=?1")
  Ad getAdByBusinessId(@Param("business_id") String business_id);
}
