package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.AdImage;
import com.example.dailycoorderbackend.repository.AdImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AdImageController {
  private final AdImageRepository ad_imageImageRepository;

  public AdImageController(AdImageRepository ad_imageRepository) {
    this.ad_imageImageRepository = ad_imageRepository;
  }

  @GetMapping("/ad_image")
  public List<AdImage> getAllAdImages() {
    return ad_imageImageRepository.findAll();
  }

  @PostMapping("/ad_image")
  public AdImage createAdImage(@RequestBody AdImage ad_image) {
    return ad_imageImageRepository.save(ad_image);
  }

  @GetMapping("/ad_image/{ad_image_id}")
  public ResponseEntity<AdImage> getAdImageById(@PathVariable long ad_image_id) {
    AdImage ad_image = ad_imageImageRepository.findById(ad_image_id).
      orElseThrow(() -> new ResourceNotFoundException("AdImage not exist with id: " + ad_image_id));

    return ResponseEntity.ok(ad_image);
  }

  @PutMapping("/ad_image/{ad_image_id}")
  public ResponseEntity<AdImage> updateAdImage(@PathVariable long ad_image_id, @RequestBody AdImage changedAdImage) {
    AdImage ad_image = ad_imageImageRepository.findById(ad_image_id).
      orElseThrow(() -> new ResourceNotFoundException("AdImage not exist with id: " + ad_image_id));

    ad_image.setAd_image_file(changedAdImage.getAd_image_file());
    ad_image.setAd_image_name(changedAdImage.getAd_image_name());

    AdImage updateAdImage = ad_imageImageRepository.save(ad_image);

    return ResponseEntity.ok(updateAdImage);
  }

  @DeleteMapping("/ad_image/{ad_image_id}")
  public ResponseEntity<Map<String, Boolean>> deleteAdImage(@PathVariable long ad_image_id) {
    AdImage ad_image = ad_imageImageRepository.findById(ad_image_id).
      orElseThrow(() -> new ResourceNotFoundException("AdImage not exist with id: " + ad_image_id));

    ad_imageImageRepository.delete(ad_image);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
