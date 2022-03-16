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

  @Column(name = "member_password")
  private String member_password;

  @Column(name = "is_business")
  private boolean is_business;

  public MemberId() {
  }

  public MemberId(String member_id, String member_password, boolean is_business) {
    this.member_id = member_id;
    this.member_password = member_password;
    this.is_business = is_business;
  }

  public String getMember_id() {
    return member_id;
  }

  public void setMember_id(String member_id) {
    this.member_id = member_id;
  }

  public String getMember_password() {
    return member_password;
  }

  public void setMember_password(String member_password) {
    this.member_password = member_password;
  }

  public boolean getIs_business() {
    return is_business;
  }

  public void setIs_business(boolean is_business) {
    this.is_business = is_business;
  }
}
