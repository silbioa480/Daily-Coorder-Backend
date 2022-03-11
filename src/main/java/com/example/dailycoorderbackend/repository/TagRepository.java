package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
//    @Query("select b from  tag where (tag_name like '%20대%' or tag_name like '%여성%' or tag_name like '%핫%')  t, board b  where t.board_id = b.board_id", nativeQuery=true)

}



