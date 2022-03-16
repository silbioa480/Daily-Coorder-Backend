package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {
    @Query("select b from BoardLike b where b.board_id=?1 and b.board_like_user_id=?2")
    BoardLike checkLike(@Param("board_id") long board_id, @Param("board_like_user_id") String board_like_user_id);

}
