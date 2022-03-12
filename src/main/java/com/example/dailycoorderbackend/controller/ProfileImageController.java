package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.ProfileImage;
import com.example.dailycoorderbackend.repository.ProfileImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ProfileImageController {

  private final ProfileImageRepository profileImageRepository;

  public ProfileImageController(ProfileImageRepository profile_imageRepository) {
    this.profileImageRepository = profile_imageRepository;
  }

  @GetMapping("/profile_image")
  public List<ProfileImage> getAllProfileImages() {
    return profileImageRepository.findAll();
  }

  @PostMapping("/profile_image")
  public ProfileImage createProfileImage(@RequestBody ProfileImage profile_image) {
    return profileImageRepository.save(profile_image);
  }

  @GetMapping("/profile_image/{profile_image_id}")
  public ResponseEntity<ProfileImage> getProfileImageById(@PathVariable long profile_image_id) {
    ProfileImage profile_image = profileImageRepository.findById(profile_image_id).
      orElseThrow(() -> new ResourceNotFoundException("ProfileImage not exist with id: " + profile_image_id));

    return ResponseEntity.ok(profile_image);
  }

  @PutMapping("/profile_image/{profile_image_id}")
  public ResponseEntity<ProfileImage> updateProfileImage(@PathVariable long profile_image_id, @RequestBody ProfileImage changedProfileImage) {
    ProfileImage profile_image = profileImageRepository.findById(profile_image_id).
      orElseThrow(() -> new ResourceNotFoundException("ProfileImage not exist with id: " + profile_image_id));

    profile_image.setProfile_image_file(changedProfileImage.getProfile_image_file());
    profile_image.setProfile_image_name(changedProfileImage.getProfile_image_name());

    ProfileImage updateProfileImage = profileImageRepository.save(profile_image);

    return ResponseEntity.ok(updateProfileImage);
  }

  @DeleteMapping("/profile_image/{profile_image_id}")
  public ResponseEntity<Map<String, Boolean>> deleteProfileImage(@PathVariable long profile_image_id) {
    ProfileImage profile_image = profileImageRepository.findById(profile_image_id).
      orElseThrow(() -> new ResourceNotFoundException("ProfileImage not exist with id: " + profile_image_id));

    profileImageRepository.delete(profile_image);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
