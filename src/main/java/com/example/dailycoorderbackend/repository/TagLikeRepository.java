package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.TagLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagLikeRepository extends JpaRepository<TagLike, Long> {


    @Query("SELECT T1.tag_name FROM TagLike T1 WHERE T1.member_id = :member_id GROUP BY T1.tag_name ORDER BY count(T1.tag_name) DESC")
    List<String> getTagNameByMemberId(@Param("member_id") String member_id);

}
