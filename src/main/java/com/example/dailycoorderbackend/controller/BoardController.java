package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Board;
import com.example.dailycoorderbackend.repository.BoardRepository;
import org.springframework.data.domain.PageRequest;
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


  @GetMapping("/board/{board_id}")
  public ResponseEntity<Board> getBoardById(@PathVariable Long board_id) {
    Board board = boardRepository.findById(board_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_id));

    return ResponseEntity.ok(board);
  }

  @GetMapping("/board/cnt")
  public Long getBoardCount() {
    return boardRepository.count();
  }

  @GetMapping("/board/page/{startrow}")
  public List<Board> getBoardLikePage(@PathVariable int startrow) {
     System.out.println(startrow);
     List <Board> boardList = boardRepository.findAll();
     int cnt =boardList.size()-startrow;
     if(cnt<=0) return boardList;
     int endrow = startrow+(cnt<10? cnt: 10);
     List <Board> subList = boardList.subList(startrow, endrow);
     System.out.println("subList size:"+subList.size());
     return subList;
  }
//    return boardRepository.findTop10OrderByBoardLikeNumberDesc();


//  @GetMapping("/board/page/{startrow}")
//  public List<Board> getBoardLikePage(@PathVariable int startrow) {
//
//    return boardRepository.findAllOrderByGreaterThan( PageRequest.of(startrow, 10));
//  }

  @GetMapping("/board/board_poster/{board_poster}")
  public List<Board> getBoardByUserId(@PathVariable String board_poster) {
    return boardRepository.getBoardByUserId(board_poster);
  }

  @PutMapping("/board/{board_id}")
  public ResponseEntity<Board> updateBoard(@PathVariable Long board_id, @RequestBody Board changedBoard) {
    Board board = boardRepository.findById(board_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_id));

    board.setBoard_image(changedBoard.getBoard_image());
    board.setBoard_title(changedBoard.getBoard_title());
    board.setBoard_content(changedBoard.getBoard_content());
    board.setBoard_url(changedBoard.getBoard_url());
    board.setBoard_like_number(changedBoard.getBoard_like_number());
    board.setBoard_view(changedBoard.getBoard_view());
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
