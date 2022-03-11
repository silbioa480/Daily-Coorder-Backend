package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends JpaRepository<Follow, Long> {
  @Query("select to_user_id from Follow where from_user_id=?1")
  String[] findByFromUserId(@Param("from_user_id") String from_user_id);
}
