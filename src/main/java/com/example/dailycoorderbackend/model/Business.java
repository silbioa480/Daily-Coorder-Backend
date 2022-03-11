package com.example.dailycoorderbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "business")
public class Business {

  @Id
  @Column(name = "business_id")
  private String business_id;

  @Column(name = "business_profile")
  private long business_profile;

  @Column(name = "business_password")
  private String business_password;

  @Column(name = "business_name")
  private String business_name;

  @Column(name = "business_number")
  private String business_number;

  @Column(name = "business_phone")
  private String business_phone;

  @Column(name = "business_email")
  private String business_email;

  @Column(name = "business_follow_number")
  private int business_follow_number;

  @Column(name = "business_follower_number")
  private int business_follower_number;

  @Column(name = "business_is_ad")
  private boolean business_is_ad;

  @Column(name = "business_is_location")
  private boolean business_is_location;

  @Column(name = "business_signup_date")
  private Date business_signup_date;

  @Column(name = "business_update_date")
  private Date business_update_date;


  public Business() {
  }

  public Business(String business_id, long business_profile, String business_password, String business_name, String business_number, String business_phone, String business_email, int business_follow_number, int business_follower_number, boolean business_is_ad, boolean business_is_location, Date business_signup_date, Date business_update_date) {
    this.business_id = business_id;
    this.business_profile = business_profile;
    this.business_password = business_password;
    this.business_name = business_name;
    this.business_number = business_number;
    this.business_phone = business_phone;
    this.business_email = business_email;
    this.business_follow_number = business_follow_number;
    this.business_follower_number = business_follower_number;
    this.business_is_ad = business_is_ad;
    this.business_is_location = business_is_location;
    this.business_signup_date = business_signup_date;
    this.business_update_date = business_update_date;
  }

  public String getBusiness_id() {
    return business_id;
  }

  public void setBusiness_id(String business_id) {
    this.business_id = business_id;
  }

  public long getBusiness_profile() {
    return business_profile;
  }

  public void setBusiness_profile(long business_profile) {
    this.business_profile = business_profile;
  }

  public String getBusiness_password() {
    return business_password;
  }

  public void setBusiness_password(String business_password) {
    this.business_password = business_password;
  }

  public String getBusiness_name() {
    return business_name;
  }

  public void setBusiness_name(String business_name) {
    this.business_name = business_name;
  }

  public String getBusiness_number() {
    return business_number;
  }

  public void setBusiness_number(String business_number) {
    this.business_number = business_number;
  }

  public String getBusiness_phone() {
    return business_phone;
  }

  public void setBusiness_phone(String business_phone) {
    this.business_phone = business_phone;
  }

  public String getBusiness_email() {
    return business_email;
  }

  public void setBusiness_email(String business_email) {
    this.business_email = business_email;
  }

  public int getBusiness_follow_number() {
    return business_follow_number;
  }

  public void setBusiness_follow_number(int business_follow_number) {
    this.business_follow_number = business_follow_number;
  }

  public int getBusiness_follower_number() {
    return business_follower_number;
  }

  public void setBusiness_follower_number(int business_follower_number) {
    this.business_follower_number = business_follower_number;
  }

  public boolean getBusiness_is_ad() {
    return business_is_ad;
  }

  public void setBusiness_is_ad(boolean business_is_ad) {
    this.business_is_ad = business_is_ad;
  }

  public boolean getBusiness_is_location() {
    return business_is_location;
  }

  public void setBusiness_is_location(boolean business_is_location) {
    this.business_is_location = business_is_location;
  }

  public Date getBusiness_signup_date() {
    return business_signup_date;
  }

  public void setBusiness_signup_date(Date business_signup_date) {
    this.business_signup_date = business_signup_date;
  }

  public Date getBusiness_update_date() {
    return business_update_date;
  }

  public void setBusiness_update_date(Date business_update_date) {
    this.business_update_date = business_update_date;
  }
}
