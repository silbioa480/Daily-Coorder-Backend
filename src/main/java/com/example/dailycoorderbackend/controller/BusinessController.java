package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.Business;
import com.example.dailycoorderbackend.repository.BusinessRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BusinessController {

  private final BusinessRepository businessRepository;

  public BusinessController(BusinessRepository businessRepository) {
    this.businessRepository = businessRepository;
  }

  @GetMapping("/business")
  public List<Business> getAllBusiness() {
    return businessRepository.findAll();
  }

  @PostMapping("/business")
  public Business createBusiness(@RequestBody Business business) {
    return businessRepository.save(business);
  }

  @GetMapping("/business/{business_id}")
  public ResponseEntity<Business> getBusinessById(@PathVariable String business_id) {
    Business business = businessRepository.findById(business_id).
      orElseThrow(() -> new ResourceNotFoundException("Business not exist with id: " + business_id));

    return ResponseEntity.ok(business);
  }

  @PutMapping("/business/{business_id}")
  public ResponseEntity<Business> updateBusiness(@PathVariable String business_id, @RequestBody Business changedBusiness) {
    Business business = businessRepository.findById(business_id).
      orElseThrow(() -> new ResourceNotFoundException("Business not exist with id: " + business_id));

    business.setBusiness_password(changedBusiness.getBusiness_password());
    business.setBusiness_name(changedBusiness.getBusiness_name());
    business.setBusiness_number(changedBusiness.getBusiness_number());
//    business.setBusiness_url(changedBusiness.getBusiness_url());
    business.setBusiness_phone(changedBusiness.getBusiness_phone());
    business.setBusiness_email(changedBusiness.getBusiness_email());
    business.setBusiness_follow_number(changedBusiness.getBusiness_follow_number());
    business.setBusiness_follower_number(changedBusiness.getBusiness_follower_number());
    business.setBusiness_is_ad(changedBusiness.getBusiness_is_ad());
    business.setBusiness_is_ad(changedBusiness.getBusiness_is_ad());

    Business updateBusiness = businessRepository.save(business);

    return ResponseEntity.ok(updateBusiness);
  }

  @DeleteMapping("/business/{business_id}")
  public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String business_id) {
    Business business = businessRepository.findById(business_id).
      orElseThrow(() -> new ResourceNotFoundException("Business not exist with id: " + business_id));

    businessRepository.delete(business);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}

