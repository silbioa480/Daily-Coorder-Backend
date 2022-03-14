package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 // 팔로우 데이터 가져오기
public interface FollowRepository extends JpaRepository<Follow, Long> {
     @Query("select to_user_id from Follow where from_user_id=?1")
     String[] findByFromUserId(@Param("from_user_id") String from_user_id);

    @Query("select f from Follow f where f.from_user_id=?1 and f.to_user_id=?2")
    Follow checkFollow(@Param("from_user_id") String from_user_id , @Param("to_user_id") String to_user_id);
 }
