package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "profile_image")
public class ProfileImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long profile_image_id;

  @Column(name = "profile_image_file", length = 1000)
  private byte[] profile_image_file;

  @Column(name = "profile_image_type")
  private String profile_image_type;

  @Column(name = "profile_image_name")
  private String profile_image_name;

  public ProfileImage() {
  }

  public ProfileImage(byte[] profile_image_file, String profile_image_type, String profile_image_name) {
    this.profile_image_file = profile_image_file;
    this.profile_image_type = profile_image_type;
    this.profile_image_name = profile_image_name;
  }

  public long getProfile_image_id() {
    return profile_image_id;
  }

  public void setProfile_image_id(long profile_image_id) {
    this.profile_image_id = profile_image_id;
  }

  public byte[] getProfile_image_file() {
    return profile_image_file;
  }

  public void setProfile_image_file(byte[] profile_image_file) {
    this.profile_image_file = profile_image_file;
  }

  public String getProfile_image_name() {
    return profile_image_name;
  }

  public void setProfile_image_name(String profile_image_name) {
    this.profile_image_name = profile_image_name;
  }

  public String getProfile_image_type() {
    return profile_image_type;
  }

  public void setProfile_image_type(String profile_image_type) {
    this.profile_image_type = profile_image_type;
  }
}
