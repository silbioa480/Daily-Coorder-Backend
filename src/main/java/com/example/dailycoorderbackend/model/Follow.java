package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "follow_id")
    private long follow_id;

    @Column(name = "from_user_id")
    private String from_user_id;

    @Column(name = "to_user_id")
    private String to_user_id;


    public Follow(){}
    public Follow(long follow_id, String from_user_id, String to_user_id) {
        this.follow_id = follow_id;
        this.from_user_id = from_user_id;
        this.to_user_id = to_user_id;
    }

    public long getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(long follow_id) {
        this.follow_id = follow_id;
    }

    public String getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(String from_user_id) {
        this.from_user_id = from_user_id;
    }

    public String getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(String to_user_id) {
        this.to_user_id = to_user_id;
    }
}


