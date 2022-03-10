package com.example.dailycoorderbackend.controller;


import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.UserProfile;
import com.example.dailycoorderbackend.repository.UserProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserProfileController {
    private final UserProfileRepository userProfileRepository;

    public UserProfileController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository =userProfileRepository;
    }

    @GetMapping("/userProfile")
    public List<UserProfile> getAllUserProfile() {
        return userProfileRepository.findAll();
    }

    @PostMapping("/userProfile/")
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @GetMapping("/userProfile/{userProfile_id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long userProfile_id) {
        UserProfile business = userProfileRepository.findById(userProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + userProfile_id));

        return ResponseEntity.ok(business);
    }

    @PutMapping("/userProfile/{userProfile_id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long userProfile_id, @RequestBody UserProfile changedUserProfile) {
        UserProfile userProfile = userProfileRepository.findById(userProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Tag not exist with id: " + userProfile_id));

        UserProfile updateUserProfile = userProfileRepository.save(userProfile);

        return ResponseEntity.ok(updateUserProfile);

    }

    @DeleteMapping("/userProfile/{userProfile_id}")
    public ResponseEntity<Map<String, Boolean>> deleteUserProfile(@PathVariable Long userProfile_id) {
        UserProfile userProfile = userProfileRepository.findById(userProfile_id).
                orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + userProfile_id));

       userProfileRepository.delete(userProfile);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

}

