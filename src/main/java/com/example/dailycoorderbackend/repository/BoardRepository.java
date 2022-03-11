package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
  @Query("select b from Board b where b.board_poster=?1")
  List<Board> getBoardByUserId(@Param("board_poster") String board_poster);
}
