package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.User;
import com.example.dailycoorderbackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @GetMapping("/users/{user_id}")
  public ResponseEntity<User> getUserById(@PathVariable String user_id) {
    User user = userRepository.findById(user_id).
      orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

    return ResponseEntity.ok(user);
  }

  @PutMapping("/users/{user_id}")
  public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody User changedUser) {
    User user = userRepository.findById(user_id).
      orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

    user.setUser_password(changedUser.getUser_password());
    user.setUser_name(changedUser.getUser_name());
    user.setUser_birth(changedUser.getUser_birth());
    user.setUser_gender(changedUser.getUser_gender());
    user.setUser_email(changedUser.getUser_email());
    user.setUser_nickname(changedUser.getUser_nickname());
    user.setUser_weight(changedUser.getUser_weight());
    user.setUser_height(changedUser.getUser_height());
    user.setUser_follow_number(changedUser.getUser_follow_number());
    user.setUser_follower_number(changedUser.getUser_follower_number());
    user.setUser_id(changedUser.getUser_id());
    user.setUser_is_location(changedUser.getUser_is_location());
    user.setUser_is_admin(changedUser.getUser_is_admin());
    user.setUser_tag(changedUser.getUser_tag());
    user.setInsert_date(changedUser.getInsert_date());
    user.setUpdate_date(changedUser.getUpdate_date());

    User updateUser = userRepository.save(user);

    return ResponseEntity.ok(updateUser);
  }

  @DeleteMapping("/users/{user_id}")
  public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String user_id) {
    User user = userRepository.findById(user_id).
      orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
