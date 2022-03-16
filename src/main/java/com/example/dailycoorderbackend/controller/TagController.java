package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Tag;
import com.example.dailycoorderbackend.repository.TagRepository;
import org.springframework.data.repository.query.Param;
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
    public Tag createTag(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @GetMapping("/tag/{tag_id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long tag_id) {
        Tag tag = tagRepository.findById(tag_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + tag_id));

        return ResponseEntity.ok(tag);
    }

    @GetMapping("/tag/tag_name/{tag_name}")
    public ResponseEntity<Long[]> getBoardIdByTagName(@PathVariable String tag_name) {
        Long[] boardId = tagRepository.findByTagName(tag_name);

        return ResponseEntity.ok(boardId);
    }

    @GetMapping("/tag/tag_names/{board_id}")
    public ResponseEntity<String[]> getTageNamesByBoardId(@PathVariable Long board_id) {
        System.out.println("board_id:" + board_id);
        String[] tagNames = tagRepository.findTagByBoardId(board_id);

        return ResponseEntity.ok(tagNames);
    }

    @PutMapping("/tag/{tag_id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long tag_id, @RequestBody Tag changedTag) {
        Tag tag = tagRepository.findById(tag_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + tag_id));

        tag.setBoard_id(changedTag.getBoard_id());
        tag.setTag_name(changedTag.getTag_name());

        Tag updateTag = tagRepository.save(tag);

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

