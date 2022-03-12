package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.CommentLike;
import com.example.dailycoorderbackend.repository.CommentLikeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CommentLikeController {
    private final CommentLikeRepository commentLikeRepository;

    public CommentLikeController(CommentLikeRepository commentRepository) {
        this.commentLikeRepository = commentRepository;
    }

    @GetMapping("/comment_like")
    public List<CommentLike> getAllCommentLike() {
        return commentLikeRepository.findAll();
    }

    @PostMapping("/comment_like")
    public CommentLike createCommentLike(@RequestBody CommentLike commentLike) {
        return commentLikeRepository.save(commentLike);
    }

    @GetMapping("/comment_like/{comment_like_id}")
    public ResponseEntity<CommentLike> getCommentLikeById(@PathVariable Long comment_like_id) {
        CommentLike commentLike = commentLikeRepository.findById(comment_like_id).
          orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + comment_like_id));

        return ResponseEntity.ok(commentLike);
    }

    @PutMapping("/comment_like/{comment_like_id}")
    public ResponseEntity<CommentLike> updateCommentLike(@PathVariable Long comment_like_id, @RequestBody CommentLike changeCommentLike) {
        CommentLike commentLike = commentLikeRepository.findById(comment_like_id).
          orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + comment_like_id));

        commentLike.setComment_id(changeCommentLike.getComment_id());
        commentLike.setComment_like_user_id(changeCommentLike.getComment_like_user_id());

        CommentLike updateCommentLike = commentLikeRepository.save(commentLike);

        return ResponseEntity.ok(updateCommentLike);
    }

    @DeleteMapping("/comment_like/{comment_like_id}")
    public ResponseEntity<Map<String, Boolean>> deleteCommentLike(@PathVariable Long comment_like_id) {
        CommentLike commentLike = commentLikeRepository.findById(comment_like_id).
          orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + comment_like_id));

        commentLikeRepository.delete(commentLike);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
