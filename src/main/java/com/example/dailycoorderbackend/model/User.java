package com.example.dailycoorderbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "user_id")
  private String user_id;

  @Column(name = "user_password")
  private String user_password;

  @Column(name = "user_name")
  private String user_name;

  @Column(name = "user_gender")
  private boolean user_gender;

  @Column(name = "user_birth")
  private Date user_birth;

  @Column(name = "user_nickname")
  private String user_nickname;

  @Column(name = "user_phone")
  private String user_phone;

  @Column(name = "user_email")
  private String user_email;

  @Column(name = "user_weight")
  private float user_weight;

  @Column(name = "user_height")
  private float user_height;

  @Column(name = "is_admin")
  private boolean isAdmin;

  public User() {
  }

  public User(String user_id, String user_password, String user_name, boolean user_gender, Date user_birth, String user_nickname, String user_phone, String user_email, float user_weight, float user_height, boolean isAdmin) {
    this.user_id = user_id;
    this.user_password = user_password;
    this.user_name = user_name;
    this.user_gender = user_gender;
    this.user_birth = user_birth;
    this.user_nickname = user_nickname;
    this.user_phone = user_phone;
    this.user_email = user_email;
    this.user_weight = user_weight;
    this.user_height = user_height;
    this.isAdmin = isAdmin;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUser_password() {
    return user_password;
  }

  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public boolean getUser_gender() {
    return user_gender;
  }

  public void setUser_gender(boolean user_gender) {
    this.user_gender = user_gender;
  }

  public Date getUser_birth() {
    return user_birth;
  }

  public void setUser_birth(Date user_birth) {
    this.user_birth = user_birth;
  }

  public String getUser_nickname() {
    return user_nickname;
  }

  public void setUser_nickname(String user_nickname) {
    this.user_nickname = user_nickname;
  }

  public String getUser_phone() {
    return user_phone;
  }

  public void setUser_phone(String user_phone) {
    this.user_phone = user_phone;
  }

  public String getUser_email() {
    return user_email;
  }

  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }

  public float getUser_weight() {
    return user_weight;
  }

  public void setUser_weight(float user_weight) {
    this.user_weight = user_weight;
  }

  public float getUser_height() {
    return user_height;
  }

  public void setUser_height(float user_height) {
    this.user_height = user_height;
  }

  public boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(boolean is_admin) {
    isAdmin = is_admin;
  }
}
