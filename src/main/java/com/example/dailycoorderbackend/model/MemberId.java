package com.example.dailycoorderbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_id")
public class MemberId {

  @Id
  @Column(name = "member_id")
  private String member_id;

  public MemberId() {
  }

  public MemberId(String member_id) {
    this.member_id = member_id;
  }

  public String getMember_id() {
    return member_id;
  }

  public void setMember_id(String member_id) {
    this.member_id = member_id;
  }
}
