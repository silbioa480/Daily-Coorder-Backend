package com.example.dailycoorderbackend.controller;


import com.example.dailycoorderbackend.repository.AdImageRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AdImageController {

    private final AdImageRepository adimageRepository;

    public AdImageController(AdImageRepository adimageRepository) {
        this.adimageRepository = adimageRepository;
    }
}
