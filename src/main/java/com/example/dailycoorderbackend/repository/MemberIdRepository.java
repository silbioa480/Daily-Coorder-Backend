package com.example.dailycoorderbackend.repository;

import com.example.dailycoorderbackend.model.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberIdRepository extends JpaRepository<MemberId, String> {
}
