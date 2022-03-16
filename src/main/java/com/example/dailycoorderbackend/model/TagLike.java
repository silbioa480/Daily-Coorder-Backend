package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tag_like")
public class TagLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag_like_id;

    @Column(name = "member_id")
    private String member_id;

    @Column(name = "tag_name")
    private String tag_name;

    public TagLike() {}

    public TagLike(long tag_like_id, String member_id, String tag_name) {
        this.tag_like_id = tag_like_id;
        this.member_id = member_id;
        this.tag_name = tag_name;

    }

    public long getTag_like_id() {
        return tag_like_id;
    }

    public void setTag_like_id(long tag_like_id) {
        this.tag_like_id = tag_like_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
