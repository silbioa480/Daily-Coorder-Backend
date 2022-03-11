package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.model.Board;
import com.example.dailycoorderbackend.repository.Board_likeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class Board_likeController {

    private Board_likeRepository board_likeRepository;

    public Board_likeController(Board_likeRepository board_likeRepository) {
        this.board_likeRepository = board_likeRepository;
    }

    @GetMapping("/board_like")
    public List<Board> getAllBoard_like() {return board_likeRepository.findAll();}


}

