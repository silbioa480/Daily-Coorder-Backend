package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.BoardImage;
import com.example.dailycoorderbackend.repository.BoardImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class BoardImageController {

    private final BoardImageRepository boardImageRepository;
    @Autowired
    private ServletContext servletContext;

    public BoardImageController(BoardImageRepository boardImageRepository) {
        this.boardImageRepository = boardImageRepository;
    }

    @GetMapping("/board_image")
    public List<BoardImage> getAllBoardImage() {
        return boardImageRepository.findAll();
    }

    @PostMapping("/board_image")
    public BoardImage createBoardImage(@RequestBody BoardImage boardImage) {
        return boardImageRepository.save(boardImage);
    }

    @GetMapping("/board_image/{board_image_id}")
    public ResponseEntity<BoardImage> getBoardImageById(@PathVariable Long board_image_id) {
        BoardImage boardImage = boardImageRepository.findById(board_image_id).
                orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

        return ResponseEntity.ok(boardImage);
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


    @PutMapping("/board_image/{board_image_id}")
    public ResponseEntity<BoardImage> updateBoardImage(@PathVariable Long board_image_id, @RequestBody BoardImage changeBoardImage) {
        BoardImage boardImage = boardImageRepository.findById(board_image_id).
                orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

        boardImage.setBoard_image_file(changeBoardImage.getBoard_image_file());
        boardImage.setBoard_image_name(changeBoardImage.getBoard_image_name());

        BoardImage updateBoardImage = boardImageRepository.save(boardImage);

        return ResponseEntity.ok(updateBoardImage);
    }

    @DeleteMapping("/board_image/{board_image_id}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardImage(@PathVariable Long board_image_id) {
        BoardImage boardImage = boardImageRepository.findById(board_image_id).
                orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + board_image_id));

        boardImageRepository.delete(boardImage);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
