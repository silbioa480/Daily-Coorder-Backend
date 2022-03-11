package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Board;
import com.example.dailycoorderbackend.repository.BoardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BoardController {

  private final BoardRepository boardRepository;

  public BoardController(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @GetMapping("/board")
  public List<Board> getAllBoard() {
    return boardRepository.findAll();
  }

  @PostMapping("/board")
  public Board createBoard(@RequestBody Board board) {
    return boardRepository.save(board);
  }

  @GetMapping("/board/{board_id}")
  public ResponseEntity<Board> getBoardById(@PathVariable Long board_id) {
    Board board = boardRepository.findById(board_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_id));

    return ResponseEntity.ok(board);
  }

  @PutMapping("/board/{board_id}")
  public ResponseEntity<Board> updateBoard(@PathVariable Long board_id, @RequestBody Board changedBoard) {
    Board board = boardRepository.findById(board_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_id));


    board.setBoard_image(changedBoard.getBoard_image());
    board.setBoard_title(changedBoard.getBoard_title());
    board.setBoard_content(changedBoard.getBoard_content());
    board.setBoard_url(changedBoard.getBoard_url());
    board.setBoard_like_num(changedBoard.getBoard_like_num());
    board.setBoard_view(changedBoard.getBoard_view());
    board.setBoard_post_date(changedBoard.getBoard_post_date());
    board.setBoard_update_date(changedBoard.getBoard_update_date());

    Board updateBoard = boardRepository.save(board);

    return ResponseEntity.ok(updateBoard);
  }

  @DeleteMapping("/board/{board_id}")
  public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Long board_id) {
    Board board = boardRepository.findById(board_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_id));

    boardRepository.delete(board);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
