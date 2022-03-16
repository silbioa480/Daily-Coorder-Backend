package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.BoardImage;
import com.example.dailycoorderbackend.repository.BoardImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/api/")
public class BoardImageController {

  private final BoardImageRepository boardImageRepository;
  @Autowired
  private ServletContext servletContext;

  public BoardImageController(BoardImageRepository boardImageRepository) {
    this.boardImageRepository = boardImageRepository;
  }

  @PostMapping("/board_image")
  public Long uploadImage(@RequestParam("ImageFile") MultipartFile file) throws IOException {
    BoardImage image = new BoardImage(compressBytes(file.getBytes()), file.getContentType(), file.getOriginalFilename());

    return boardImageRepository.addImage(image);
  }

  @GetMapping("/board_image/{board_image_id}")
  public byte[] getImage(@PathVariable Long board_image_id, HttpServletResponse response) {
    BoardImage image = boardImageRepository.findById(board_image_id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    image.setBoard_image_file(decompressBytes(image.getBoard_image_file()));
    response.setContentType(image.getBoard_image_type());

    return image.getBoard_image_file();
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

  @GetMapping(value = "/board_img/{filename}")
  public void fileview(@PathVariable String filename,
                       HttpServletRequest request, HttpServletResponse response) {
    System.out.println(filename);
    String path = servletContext.getRealPath("/image/");
    //String path = "/upload/";
    File file = new File(path + filename);
    String sfilename = null;
    FileInputStream fis = null;
    try {
      if (request.getHeader("User-Agent").indexOf("MSIE") > -1) {
        sfilename = URLEncoder.encode(file.getName(), "utf-8");
      } else {
        sfilename = new String(file.getName().getBytes("utf-8"), "ISO-8859-1");
      }
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/octet-stream;charset=utf-8");
      //response.setHeader("Content-Disposition", "attachment; filename=\""+sfilename+"\";");
      response.setHeader("Content-Disposition", "attachment; filename=" + sfilename);
      OutputStream out = response.getOutputStream();
      fis = new FileInputStream(file);
      FileCopyUtils.copy(fis, out);
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
        }
      }
    }
  }
}
