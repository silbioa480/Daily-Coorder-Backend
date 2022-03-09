package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Tag;
import com.example.dailycoorderbackend.repository.TagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class TagController {

  private final TagRepository tagRepository;

  public TagController(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @GetMapping("/tag")
  public List<Tag> getAllTag() {
    return tagRepository.findAll();
  }

  @PostMapping("/tag")
  public Tag createTag(@RequestBody Tag board) {
    return tagRepository.save(board);
  }

  @GetMapping("/tag/{tag_id}")
  public ResponseEntity<Tag> getTagById(@PathVariable Long tag_id) {
    Tag business = tagRepository.findById(tag_id).
      orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + tag_id));

    return ResponseEntity.ok(business);
  }

  @PutMapping("/tag/{tag_id}")
  public ResponseEntity<Tag> updateTag(@PathVariable Long tag_id, @RequestBody Tag changedTag) {
    Tag board = tagRepository.findById(tag_id).
      orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + tag_id));


    Tag updateTag = tagRepository.save(board);

    return ResponseEntity.ok(updateTag);
  }

  @DeleteMapping("/tag/{tag_id}")
  public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long tag_id) {
    Tag tag = tagRepository.findById(tag_id).
      orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + tag_id));

    tagRepository.delete(tag);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}

