package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Board;
import com.example.dailycoorderbackend.model.BoardLike;
import com.example.dailycoorderbackend.repository.BoardLikeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BoardLikeController {

  private final BoardLikeRepository boardLikeRepository;

  public BoardLikeController(BoardLikeRepository boardLikeRepository) {
    this.boardLikeRepository = boardLikeRepository;
  }

  @GetMapping("/board_like")
  public List<BoardLike> getAllBoard_like() {
    return boardLikeRepository.findAll();
  }

  @PostMapping("/board_like")
  public BoardLike createBoardLike(@RequestBody BoardLike boardLike) {
    return boardLikeRepository.save(boardLike);
  }

  @GetMapping("/board_like/{board_like_id}")
  public ResponseEntity<BoardLike> getBoardLikeById(@PathVariable Long board_like_id) {
    BoardLike boardLike = boardLikeRepository.findById(board_like_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_like_id));

    return ResponseEntity.ok(boardLike);
  }

  @GetMapping("/board_like/{board_id}/{board_like_user_id}")
  public ResponseEntity<BoardLike> checkLike(@PathVariable long board_id, @PathVariable String board_like_user_id) {
    BoardLike boardLike = boardLikeRepository.checkLike(board_id, board_like_user_id);

    return ResponseEntity.ok(boardLike);
  }

  @PutMapping("/board_like/{board_like_id}")
  public ResponseEntity<BoardLike> updateBoardLike(@PathVariable Long board_like_id, @RequestBody BoardLike changeBoardLike) {
    BoardLike boardLike = boardLikeRepository.findById(board_like_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_like_id));

    boardLike.setBoard_id(changeBoardLike.getBoard_id());
    boardLike.setBoard_like_user_id(changeBoardLike.getBoard_like_user_id());

    BoardLike updateBoardLike = boardLikeRepository.save(boardLike);

    return ResponseEntity.ok(updateBoardLike);
  }

  @DeleteMapping("/board_like/{board_like_id}")
  public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Long board_like_id) {
    BoardLike boardLike = boardLikeRepository.findById(board_like_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_like_id));

    boardLikeRepository.delete(boardLike);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}

