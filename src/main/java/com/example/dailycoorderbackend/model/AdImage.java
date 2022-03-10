package com.example.dailycoorderbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;

@Entity
@Table(name = "ad_image")
public class AdImage {

    @Id
    @Column(name = "ad_image_id")
    private long ad_image_id;

    @Column(name = "ad_image_file")
    private File ad_image_file;

    @Column(name = "ad_image_name")
    private String ad_image_name;

    public AdImage() {
    }

    public AdImage(long ad_image_id, File ad_image_file, String ad_image_name) {
        this.ad_image_id = ad_image_id;
        this.ad_image_file = ad_image_file;
        this.ad_image_name = ad_image_name;
    }

    public long getAd_image_id() {
        return ad_image_id;
    }

    public void setAd_image_id(long ad_image_id) {
        this.ad_image_id = ad_image_id;
    }

    public File getAd_image_file() {
        return ad_image_file;
    }

    public void setAd_image_file(File ad_image_file) {
        this.ad_image_file = ad_image_file;
    }

    public String getAd_image_name() {
        return ad_image_name;
    }

    public void setAd_image_name(String ad_image_name) {
        this.ad_image_name = ad_image_name;
    }
}
