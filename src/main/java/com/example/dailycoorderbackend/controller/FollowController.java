package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Follow;
import com.example.dailycoorderbackend.repository.FollowRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class FollowController {

  private final FollowRepository followRepository;

  public FollowController(FollowRepository followRepository) {
    this.followRepository = followRepository;
  }

  @GetMapping("/follow")
  public List<Follow> getAllFollow() {
    return followRepository.findAll();
  }

  @PostMapping("/follow")
  public Follow createFollow(@RequestBody Follow follow) {
    return followRepository.save(follow);
  }

  @GetMapping("/follow/{follow_id}")
  public ResponseEntity<Follow> getFollowById(@PathVariable Long follow_id) {
    Follow follow = followRepository.findById(follow_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + follow_id));

    return ResponseEntity.ok(follow);
  }

  @GetMapping("/follow/follower/{from_user_id}")
  public ResponseEntity<String[]> getFollowerByUserId(@PathVariable String from_user_id) {
    String[] followerId = followRepository.findByFromUserId(from_user_id);

    return ResponseEntity.ok(followerId);
  }

  @GetMapping("/follow/follower/{from_user_id}&{to_user_id}")
  public ResponseEntity<Follow> checkFollow(@PathVariable String from_user_id,@PathVariable String to_user_id) {
    Follow follow = followRepository.checkFollow(from_user_id, to_user_id);

    return ResponseEntity.ok(follow);
  }

  @PutMapping("/follow/{follow_id}")
  public ResponseEntity<Follow> updateFollow(@PathVariable Long follow_id, @RequestBody Follow changeFollow) {
    Follow follow = followRepository.findById(follow_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + follow_id));

    follow.setFrom_user_id(changeFollow.getFrom_user_id());
    follow.setTo_user_id(changeFollow.getTo_user_id());

    Follow updateFollow = followRepository.save(follow);

    return ResponseEntity.ok(updateFollow);
  }

  @DeleteMapping("/follow/{follow_id}")
  public ResponseEntity<Map<String, Boolean>> deleteFollow(@PathVariable Long follow_id) {
    Follow follow = followRepository.findById(follow_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + follow_id));

    followRepository.delete(follow);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
