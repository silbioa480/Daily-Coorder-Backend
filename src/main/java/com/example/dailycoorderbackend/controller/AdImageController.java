package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.AdImage;
import com.example.dailycoorderbackend.repository.AdImageRepository;
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
public class AdImageController {
  private final AdImageRepository adImageRepository;

  public AdImageController(AdImageRepository adImageRepository) {
    this.adImageRepository = adImageRepository;
  }

  @PostMapping("/ad_image")
  public Long uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
    AdImage image = new AdImage(compressBytes(file.getBytes()), file.getContentType(), file.getOriginalFilename());

    return adImageRepository.addImage(image);
  }

  @GetMapping("/ad_image/{ad_image_id}")
  public byte[] getImage(@PathVariable Long ad_image_id, HttpServletResponse response) {
    AdImage image = adImageRepository.findById(ad_image_id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    image.setAd_image_file(decompressBytes(image.getAd_image_file()));
    response.setContentType(image.getAd_image_type());

    return image.getAd_image_file();
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
