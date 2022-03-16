package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.User;
import com.example.dailycoorderbackend.repository.UserRepository;
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
public class UserController {

    private final UserRepository userRepository;
    @Autowired
    private ServletContext servletContext;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/one/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable String user_id) {
        User user = userRepository.findById(user_id).
                orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/user_profile/{filename}")
    public void fileview(@PathVariable String filename,
                         HttpServletRequest request, HttpServletResponse response) {
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


    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody User changedUser) {
        User user = userRepository.findById(user_id).
                orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

        user.setUser_password(changedUser.getUser_password());
        user.setUser_profile(changedUser.getUser_profile());
        user.setUser_name(changedUser.getUser_name());
        user.setUser_birth(changedUser.getUser_birth());
        user.setUser_gender(changedUser.getUser_gender());
        user.setUser_email(changedUser.getUser_email());
        user.setUser_phone(changedUser.getUser_phone());
        user.setUser_nickname(changedUser.getUser_nickname());
        user.setUser_weight(changedUser.getUser_weight());
        user.setUser_height(changedUser.getUser_height());
        user.setUser_follow_number(changedUser.getUser_follow_number());
        user.setUser_follower_number(changedUser.getUser_follower_number());
        user.setUser_is_ad(changedUser.getUser_is_ad());
        user.setUser_is_location(changedUser.getUser_is_location());
        user.setUser_is_admin(changedUser.getUser_is_admin());
        user.setUser_tag(changedUser.getUser_tag());
        user.setUser_update_date(changedUser.getUser_update_date());

        User updateUser = userRepository.save(user);

        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String user_id) {
        User user = userRepository.findById(user_id).
                orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + user_id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
