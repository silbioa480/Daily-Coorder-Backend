package com.example.dailycoorderbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ad")
public class Ad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long ad_id;

  @Column(name = "business_id")
  private String business_id;

  @Column(name = "ad_image")
  private long ad_image;

  @Column(name = "ad_title")
  private String ad_title;

  @Column(name = "ad_url")
  private String ad_url;

  @Column(name = "ad_explain")
  private String ad_explain;

  @Column(name = "ad_is_prove")
  private boolean ad_is_prove;

  @Column(name = "ad_register_date")
  private Date ad_register_date;

  @Column(name = "ad_expire")
  private int ad_expire;

  public Ad() {
  }

  public Ad(long ad_id, String business_id, long ad_image, String ad_title, String ad_url, String ad_explain, boolean ad_is_prove, Date ad_register_date, int ad_expire) {
    this.ad_id = ad_id;
    this.business_id = business_id;
    this.ad_image = ad_image;
    this.ad_title = ad_title;
    this.ad_url = ad_url;
    this.ad_explain = ad_explain;
    this.ad_is_prove = ad_is_prove;
    this.ad_register_date = ad_register_date;
    this.ad_expire = ad_expire;
  }

  public long getAd_id() {
    return ad_id;
  }

  public void setAd_id(long ad_id) {
    this.ad_id = ad_id;
  }

  public String getBusiness_id() {
    return business_id;
  }

  public void setBusiness_id(String business_id) {
    this.business_id = business_id;
  }

  public long getAd_image() {
    return ad_image;
  }

  public void setAd_image(long ad_image) {
    this.ad_image = ad_image;
  }

  public String getAd_title() {
    return ad_title;
  }

  public void setAd_title(String ad_title) {
    this.ad_title = ad_title;
  }

  public String getAd_url() {
    return ad_url;
  }

  public void setAd_url(String ad_url) {
    this.ad_url = ad_url;
  }

  public String getAd_explain() {
    return ad_explain;
  }

  public void setAd_explain(String ad_explain) {
    this.ad_explain = ad_explain;
  }

  public boolean isAd_is_prove() {
    return ad_is_prove;
  }

  public void setAd_is_prove(boolean ad_is_prove) {
    this.ad_is_prove = ad_is_prove;
  }

  public Date getAd_register_date() {
    return ad_register_date;
  }

  public void setAd_register_date(Date ad_register_date) {
    this.ad_register_date = ad_register_date;
  }

  public int getAd_expire() {
    return ad_expire;
  }

  public void setAd_expire(int ad_expire) {
    this.ad_expire = ad_expire;
  }
}
