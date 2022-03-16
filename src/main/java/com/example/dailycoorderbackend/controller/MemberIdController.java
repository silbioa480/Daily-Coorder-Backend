package com.example.dailycoorderbackend.controller;

import com.example.dailycoorderbackend.exception.ResourceNotFoundException;
import com.example.dailycoorderbackend.model.MemberId;
import com.example.dailycoorderbackend.repository.MemberIdRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class MemberIdController {
  private final MemberIdRepository member_idRepository;

  public MemberIdController(MemberIdRepository member_idRepository) {
    this.member_idRepository = member_idRepository;
  }

  @GetMapping("/member_id")
  public List<MemberId> getAllMemberId() {
    return member_idRepository.findAll();
  }

  @PostMapping("/member_id")
  public MemberId createMemberId(@RequestBody MemberId member_id) {
    return member_idRepository.save(member_id);
  }

  @GetMapping("/member_id/{member_id}")
  public ResponseEntity<MemberId> getMemberIdById(@PathVariable String member_id) {
    MemberId memberId = member_idRepository.findById(member_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + member_id));

    return ResponseEntity.ok(memberId);
  }

  @PutMapping("/member_id/{member_id}")
  public ResponseEntity<MemberId> updateMemberId(@PathVariable String member_id, @RequestBody MemberId changeMemberId) {
    MemberId memberId = member_idRepository.findById(member_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + member_id));

    memberId.setMember_password(changeMemberId.getMember_password());
    memberId.setIs_business(changeMemberId.getIs_business());

    MemberId updateMemberId = member_idRepository.save(memberId);

    return ResponseEntity.ok(updateMemberId);
  }

  @DeleteMapping("/member_id/{member_id}")
  public ResponseEntity<Map<String, Boolean>> deleteMemberId(@PathVariable String member_id) {
    MemberId memberId = member_idRepository.findById(member_id).
      orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + member_id));

    member_idRepository.delete(memberId);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
