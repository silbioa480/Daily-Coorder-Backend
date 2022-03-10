package com.example.dailycoorderbackend.model;

import java.io.File;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @Column(name = "user_profile_id")
    private long user_profile_id;

    @Column(name = "user_profile_file")
    private File user_profile_file;

    public UserProfile () {}


    public UserProfile(long user_profile_id, File user_profile_file) {
        super();
        this.user_profile_id = user_profile_id;
        this.user_profile_file = user_profile_file;
    }


    public long getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(long user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public File getUser_profile_file() {
        return user_profile_file;
    }

    public void setUser_profile_file(File user_profile_file) {
        this.user_profile_file = user_profile_file;
    }


}
