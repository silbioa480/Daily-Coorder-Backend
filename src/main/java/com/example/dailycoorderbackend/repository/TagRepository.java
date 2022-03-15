package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("select board_id from Tag where tag_name=?1")
    Long[] findByTagName(@Param("tag_name") String tag_name);

    @Query("select t.tag_name from Tag t where t.board_id=?1")
    String[] findTagByBoardId(@Param("board_id") Long board_id);


}



