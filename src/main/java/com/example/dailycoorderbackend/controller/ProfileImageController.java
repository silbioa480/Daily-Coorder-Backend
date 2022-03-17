package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.ProfileImage;
import com.example.dailycoorderbackend.repository.ProfileImageRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/api/")
public class ProfileImageController {

  private final ProfileImageRepository profileImageRepository;

  public ProfileImageController(ProfileImageRepository profileImageRepository) {
    this.profileImageRepository = profileImageRepository;
  }

  @PostMapping("/profile_image")
  public Long uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
    ProfileImage image = new ProfileImage(compressBytes(file.getBytes()), file.getContentType(), file.getOriginalFilename());

    return profileImageRepository.addImage(image);
  }

  @GetMapping("/profile_image/{profile_image_id}")
  public byte[] getImage(@PathVariable Long profile_image_id, HttpServletResponse response) {
    ProfileImage image = profileImageRepository.findById(profile_image_id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    image.setProfile_image_file(decompressBytes(image.getProfile_image_file()));
    response.setContentType(image.getProfile_image_type());

    return image.getProfile_image_file();
  }

  public static byte[] compressBytes(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setInput(data);
    deflater.finish();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];

    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);

      try {
        outputStream.close();
      } catch (IOException e) {
      }
    }

    return outputStream.toByteArray();
  }

  public static byte[] decompressBytes(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];

    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
      }

      outputStream.close();
    } catch (IOException | DataFormatException ignored) {
    }

    return outputStream.toByteArray();
  }
}
