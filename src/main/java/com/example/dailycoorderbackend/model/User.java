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

    @Column(name = "user_profile")
    private String user_profile;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_nickname")
    private String user_nickname;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "user_follow_number")
    private int user_follow_number;

    @Column(name = "user_follower_number")
    private int user_follower_number;

    @Column(name = "user_is_ad")
    private boolean user_is_ad;

    @Column(name = "user_is_location")
    private boolean user_is_location;

    @Column(name = "user_is_admin")
    private boolean user_is_admin;

    @Column(name = "user_tag")
    private String user_tag;

    @Column(name = "user_gender")
    private boolean user_gender;

    @Column(name = "user_birth")
    private Date user_birth;

    @Column(name = "user_weight")
    private float user_weight;

    @Column(name = "user_height")
    private float user_height;

    @Column(name = "user_signup_date")
    private Date user_signup_date;

    @Column(name = "user_update_date")
    private Date user_update_date;


    public User() {
    }

    public User(String user_id, String user_profile, String user_password, String user_name, String user_nickname, String user_phone, String user_email, int user_follow_number, int user_follower_number, boolean user_is_ad, boolean user_is_location, boolean user_is_admin, String user_tag, boolean user_gender, Date user_birth, float user_weight, float user_height, Date user_signup_date, Date user_update_date) {
        this.user_id = user_id;
        this.user_profile = user_profile;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_follow_number = user_follow_number;
        this.user_follower_number = user_follower_number;
        this.user_is_ad = user_is_ad;
        this.user_is_location = user_is_location;
        this.user_is_admin = user_is_admin;
        this.user_tag = user_tag;
        this.user_gender = user_gender;
        this.user_birth = user_birth;
        this.user_weight = user_weight;
        this.user_height = user_height;
        this.user_signup_date = user_signup_date;
        this.user_update_date = user_update_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_profile() {
        return user_profile;
    }

    public void setUser_profile(String user_profile) {
        this.user_profile = user_profile;
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

    public int getUser_follow_number() {
        return user_follow_number;
    }

    public void setUser_follow_number(int user_follow_number) {
        this.user_follow_number = user_follow_number;
    }

    public int getUser_follower_number() {
        return user_follower_number;
    }

    public void setUser_follower_number(int user_follower_number) {
        this.user_follower_number = user_follower_number;
    }

    public boolean getUser_is_ad() {
        return user_is_ad;
    }

    public void setUser_is_ad(boolean user_is_ad) {
        this.user_is_ad = user_is_ad;
    }

    public boolean getUser_is_location() {
        return user_is_location;
    }

    public void setUser_is_location(boolean user_is_location) {
        this.user_is_location = user_is_location;
    }

    public boolean getUser_is_admin() {
        return user_is_admin;
    }

    public void setUser_is_admin(boolean user_is_admin) {
        this.user_is_admin = user_is_admin;
    }

    public String getUser_tag() {
        return user_tag;
    }

    public void setUser_tag(String user_tag) {
        this.user_tag = user_tag;
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

    public Date getUser_signup_date() {
        return user_signup_date;
    }

    public void setUser_signup_date(Date user_signup_date) {
        this.user_signup_date = user_signup_date;
    }

    public Date getUser_update_date() {
        return user_update_date;
    }

    public void setUser_update_date(Date user_update_date) {
        this.user_update_date = user_update_date;
    }
}
