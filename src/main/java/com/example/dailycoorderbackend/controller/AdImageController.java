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

    private final AdImageRepository adimageRepository;

    public AdImageController(AdImageRepository adimageRepository) {
        this.adimageRepository = adimageRepository;
    }

    @GetMapping("/api/adimage")
    public List<AdImage> getAllImage() {
        return adimageRepository.findAll();
    }

    @PostMapping("/api/adimage")
    public AdImage createAdImage(@RequestBody AdImage adimage) {
        return adimageRepository.save(adimage);
    }

    @GetMapping("/api/adimage/{ad_image_id}")
    public ResponseEntity<AdImage> getByAdImageId(@PathVariable Long ad_image_id) {
        AdImage adi = adimageRepository.findById(ad_image_id).orElseThrow(() -> new ResourceNotFoundException("ad_image_id not exist" + ad_image_id));
        return ResponseEntity.ok(adi);
    }

    @PutMapping("/api/adimage/{ad_image_id}")
    public ResponseEntity<AdImage> updateAdImage(@PathVariable Long ad_image_id, @RequestBody AdImage adimage) {
        AdImage adi = adimageRepository.findById(ad_image_id).orElseThrow(() -> new ResourceNotFoundException("ad_image_id not exist" + ad_image_id));

        adi.setAd_image_file(adimage.getAd_image_file());
        adi.setAd_image_name(adimage.getAd_image_name());
        adi.setAd_image_id(adimage.getAd_image_id());

        AdImage updateAdi = adimageRepository.save(adi);

        return ResponseEntity.ok(updateAdi);
    }

    @DeleteMapping("/api/adimage/{ad_image_id}")
    public ResponseEntity<Map<String, Boolean>> deleteAdImage(@PathVariable Long ad_image_id) {
        AdImage adi = adimageRepository.findById(ad_image_id).orElseThrow(() -> new ResourceNotFoundException("ad_image_id not exist" + ad_image_id));

        adimageRepository.delete(adi);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
