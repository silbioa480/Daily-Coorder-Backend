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

    public BusinessProfile () {}



    public BusinessProfile(long business_profile_id, File business_profile_file) {
        super();
        this.business_profile_id = business_profile_id;
        this.business_profile_file = business_profile_file;
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
}



