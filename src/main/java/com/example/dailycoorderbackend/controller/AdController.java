package com.example.dailycoorderbackend.controller;


import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.AdTable;
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

    @GetMapping("/MyPage_Adapplication")
    public List<AdTable> getAllAdTable() {
        return adRepository.findAll();
    }

    @PostMapping("/MyPage_Adapplication")
    public AdTable createAdTable(@RequestBody AdTable adtable) {
        return adRepository.save(adtable);
    }

    @GetMapping("/MyPage_Adapplication/{ad_id}")
    public ResponseEntity<AdTable> getAdTableId(@PathVariable Long ad_id) {
        AdTable adtable = adRepository.findById(ad_id).orElseThrow(() -> new ResourceNotFoundException("ad_id not exist" + ad_id));
        return ResponseEntity.ok(adtable);
    }

    @PutMapping("/MyPage_Adapplication/{ad_id}")
    public ResponseEntity<AdTable> updateAdTable(@PathVariable Long ad_id, @RequestBody AdTable adtable) {
        AdTable adt = adRepository.findById(ad_id).orElseThrow(() -> new ResourceNotFoundException("ad_id not exit" + ad_id));

        adt.setAd_title(adtable.getAd_title());
        adt.setAd_url(adtable.getAd_url());
        adt.setAd_explain(adtable.getAd_explain());
        adt.setBusiness_id(adtable.getBusiness_id());
        adt.setAd_expire(adtable.getAd_expire());
        adt.setAd_is_prove(adtable.isAd_is_prove());
        adt.setAd_image(adtable.getAd_image());

        AdTable updateAdt = adRepository.save(adt);

        return ResponseEntity.ok(updateAdt);
    }

    @DeleteMapping("/MyPage_Adapplication/{ad_id}")
    public ResponseEntity<Map<String, Boolean>> deleteAd(@PathVariable Long ad_id) {
        AdTable adt = adRepository.findById(ad_id).orElseThrow(() -> new ResourceNotFoundException("ad_id not exit" + ad_id));

        adRepository.delete(adt);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
