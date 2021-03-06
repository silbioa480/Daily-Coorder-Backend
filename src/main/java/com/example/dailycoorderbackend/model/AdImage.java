package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "ad_image")
public class AdImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ad_image_id;

  @Column(name = "ad_image_file")
  private byte[] ad_image_file;

  @Column(name = "ad_image_type")
  private String ad_image_type;

  @Column(name = "ad_image_name")
  private String ad_image_name;

  public AdImage() {
  }

  public AdImage(byte[] ad_image_file, String ad_image_type, String ad_image_name) {
    this.ad_image_file = ad_image_file;
    this.ad_image_type = ad_image_type;
    this.ad_image_name = ad_image_name;
  }

  public long getAd_image_id() {
    return ad_image_id;
  }

  public void setAd_image_id(long ad_image_id) {
    this.ad_image_id = ad_image_id;
  }

  public byte[] getAd_image_file() {
    return ad_image_file;
  }

  public void setAd_image_file(byte[] ad_image_file) {
    this.ad_image_file = ad_image_file;
  }

  public String getAd_image_type() {
    return ad_image_type;
  }

  public void setAd_image_type(String ad_image_type) {
    this.ad_image_type = ad_image_type;
  }

  public String getAd_image_name() {
    return ad_image_name;
  }

  public void setAd_image_name(String ad_image_name) {
    this.ad_image_name = ad_image_name;
  }
}
