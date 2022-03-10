package com.example.dailycoorderbackend.controller;


import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.BusinessProfile;
import com.example.dailycoorderbackend.repository.BusinessProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BusinessProfileController {

    private final BusinessProfileRepository businessProfileRepository;

    public BusinessProfileController(BusinessProfileRepository businessProfileRepository) {
        this.businessProfileRepository = businessProfileRepository;
    }

    @GetMapping("/businessProfile")
    public List<BusinessProfile> getAllBusinessProfile() {
        return businessProfileRepository.findAll();
    }

    @PostMapping("/businessProfile/")
    public BusinessProfile createBusinessProfile(@RequestBody BusinessProfile businessProfile) {
        return businessProfileRepository.save(businessProfile);
    }

    @GetMapping("/businessProfile/{businessProfile_id}")
    public ResponseEntity<BusinessProfile> getBusinessProfileById(@PathVariable Long businessProfile_id) {
        BusinessProfile business = businessProfileRepository.findById(businessProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + businessProfile_id));

        return ResponseEntity.ok(business);
    }

    @PutMapping("/businessProfile/{businessProfile_id}")
    public ResponseEntity<BusinessProfile> updateBusinessProfile(@PathVariable Long businessProfile_id, @RequestBody BusinessProfile changedBusinessProfile) {
        BusinessProfile businessProfile = businessProfileRepository.findById(businessProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + businessProfile_id));

        BusinessProfile updateBusinessProfile = businessProfileRepository.save(businessProfile);

        return ResponseEntity.ok(updateBusinessProfile);

    }

    @DeleteMapping("/businessProfile/{businessProfile_id}")
    public ResponseEntity<Map<String, Boolean>> deleteBusinessProfile(@PathVariable Long businessProfile_id) {
        BusinessProfile businessProfile = businessProfileRepository.findById(businessProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + businessProfile_id));

        businessProfileRepository.delete(businessProfile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}
