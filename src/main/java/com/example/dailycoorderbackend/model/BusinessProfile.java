package com.example.dailycoorderbackend.model;

import java.io.File;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business_profile")
public class BusinessProfile {

    @Id
    @Column(name = "business_profile_id")
    private long business_profile_id;

    @Column(name = "business_profile_file")
    private File business_profile_file;

    @Column(name = "business_profile_name")
    private String business_profile_name;

    public BusinessProfile () {}


    public BusinessProfile(long business_profile_id, File business_profile_file, String business_profile_name) {
        super();
        this.business_profile_id = business_profile_id;
        this.business_profile_file = business_profile_file;
        this.business_profile_name = business_profile_name;
    }

    public long getBusiness_profile_id() {
        return business_profile_id;
    }

    public void setBusiness_profile_id(long business_profile_id) {
        this.business_profile_id = business_profile_id;
    }

    public File getBusiness_profile_file() {
        return business_profile_file;
    }

    public void setBusiness_profile_file(File business_profile_file) {
        this.business_profile_file = business_profile_file;
    }

    public String getBusiness_profile_name() {
        return business_profile_name;
    }

    public void setBusiness_profile_name(String business_profile_name) {
        this.business_profile_name = business_profile_name;
    }
}



