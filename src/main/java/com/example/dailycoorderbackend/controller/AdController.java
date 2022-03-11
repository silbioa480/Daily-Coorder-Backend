package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Ad;
import com.example.dailycoorderbackend.repository.AdRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AdController {

  private final AdRepository adRepository;

  public AdController(AdRepository adRepository) {
    this.adRepository = adRepository;
  }

  @GetMapping("/ad")
  public List<Ad> getAllAds() {
    return adRepository.findAll();
  }

  @PostMapping("/ad")
  public Ad createAd(@RequestBody Ad ad) {
    return adRepository.save(ad);
  }

  @GetMapping("/ad/{ad_id}")
  public ResponseEntity<Ad> getAdById(@PathVariable long ad_id) {
    Ad ad = adRepository.findById(ad_id).
      orElseThrow(() -> new ResourceNotFoundException("Ad not exist with id: " + ad_id));

    return ResponseEntity.ok(ad);
  }

  @PutMapping("/ad/{ad_id}")
  public ResponseEntity<Ad> updateAd(@PathVariable long ad_id, @RequestBody Ad changedAd) {
    Ad ad = adRepository.findById(ad_id).
      orElseThrow(() -> new ResourceNotFoundException("Ad not exist with id: " + ad_id));

    ad.setAd_image(changedAd.getAd_image());
    ad.setAd_title(changedAd.getAd_title());
    ad.setAd_url(changedAd.getAd_url());
    ad.setAd_explain(changedAd.getAd_explain());
    ad.setAd_is_prove(changedAd.isAd_is_prove());
    ad.setAd_expire(changedAd.getAd_expire());

    Ad updateAd = adRepository.save(ad);

    return ResponseEntity.ok(updateAd);
  }

  @DeleteMapping("/ad/{ad_id}")
  public ResponseEntity<Map<String, Boolean>> deleteAd(@PathVariable long ad_id) {
    Ad ad = adRepository.findById(ad_id).
      orElseThrow(() -> new ResourceNotFoundException("Ad not exist with id: " + ad_id));

    adRepository.delete(ad);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
