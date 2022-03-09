package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Comment;
import com.example.dailycoorderbackend.repository.CommentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CommentController {

  private final CommentRepository commentRepository;

  public CommentController(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @GetMapping("/comments")
  public List<Comment> getAllComment() {
    return commentRepository.findAll();
  }

  @PostMapping("/comments")
  public Comment createComment(@RequestBody Comment board) {
    return commentRepository.save(board);
  }

  @GetMapping("/comments/{comment_id}")
  public ResponseEntity<Comment> getCommentById(@PathVariable Long comment_id) {
    Comment business = commentRepository.findById(comment_id).
      orElseThrow(() -> new ResourceNotFoundException("Comment not exist with id: " + comment_id));

    return ResponseEntity.ok(business);
  }

  @PutMapping("/comments/{comment_id}")
  public ResponseEntity<Comment> updateComment(@PathVariable Long comment_id, @RequestBody Comment changedComment) {
    Comment board = commentRepository.findById(comment_id).
      orElseThrow(() -> new ResourceNotFoundException("Comment not exist with id: " + comment_id));


    Comment updateComment = commentRepository.save(board);

    return ResponseEntity.ok(updateComment);
  }

  @DeleteMapping("/comments/{comment_id}")
  public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long comment_id) {
    Comment comment = commentRepository.findById(comment_id).
      orElseThrow(() -> new ResourceNotFoundException("Comment not exist with id: " + comment_id));

    commentRepository.delete(comment);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}

