package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.repository.TagLikeRepository;
import com.example.dailycoorderbackend.repository.TagRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TagLikeController {

    private final TagLikeRepository tagLikeRepository;

    public TagLikeController(TagLikeRepository tagLikeRepository) {
        this.tagLikeRepository = tagLikeRepository;
    }

    @GetMapping("/tag_like/member_id/{member_id}")
    public List<String> getTagNameByMemberId(@PathVariable String member_id) {
        return tagLikeRepository.getTagNameByMemberId(member_id);
    }

}
