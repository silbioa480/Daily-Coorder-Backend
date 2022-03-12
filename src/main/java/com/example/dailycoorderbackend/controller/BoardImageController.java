package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.BoardImage;
import com.example.dailycoorderbackend.repository.BoardImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BoardImageController {

  private final BoardImageRepository boardImageRepository;


  public BoardImageController(BoardImageRepository boardImageRepository) {
    this.boardImageRepository = boardImageRepository;
  }

  @GetMapping("/board_image")
  public List<BoardImage> getAllBoardImage() {
    return boardImageRepository.findAll();
  }

  @PostMapping("/board_image")
  public BoardImage createBoardImage(@RequestBody BoardImage boardImage) {
    return boardImageRepository.save(boardImage);
  }

  @GetMapping("/board_image/{board_image_id}")
  public ResponseEntity<BoardImage> getBoardImageById(@PathVariable Long board_image_id) {
    BoardImage boardImage = boardImageRepository.findById(board_image_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

    return ResponseEntity.ok(boardImage);
  }

  @PutMapping("/board_image/{board_image_id}")
  public ResponseEntity<BoardImage> updateBoardImage(@PathVariable Long board_image_id, @RequestBody BoardImage changeBoardImage) {
    BoardImage boardImage = boardImageRepository.findById(board_image_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

    boardImage.setBoard_image_file(changeBoardImage.getBoard_image_file());
    boardImage.setBoard_image_name(changeBoardImage.getBoard_image_name());

    BoardImage updateBoardImage = boardImageRepository.save(boardImage);

    return ResponseEntity.ok(updateBoardImage);
  }

  @DeleteMapping("/board_image/{board_image_id}")
  public ResponseEntity<Map<String, Boolean>> deleteBoardImage(@PathVariable Long board_image_id) {
    BoardImage boardImage = boardImageRepository.findById(board_image_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

    boardImageRepository.delete(boardImage);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
