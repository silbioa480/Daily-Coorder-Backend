package com.example.dailycoorderbackend.model;


import javax.persistence.*;
@Entity
@Table(name = "comment_like")
public
class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long comment_like_id;

    @Column(name = "comment_id")
    private String comment_id;

    @Column(name = "comment_like_user_id")
    private String comment_like_user_id;



    public CommentLike(long comment_like_id, String comment_id, String comment_like_user_id) {
        this.comment_like_id = comment_like_id;
        this.comment_id = comment_id;
        this.comment_like_user_id = comment_like_user_id;

    }

    public long getComment_like_id() {
        return comment_like_id;
    }

    public void setComment_like_id(long comment_like_id) {
        this.comment_like_id = comment_like_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_like_user_id() {
        return comment_like_user_id;
    }

    public void setComment_like_user_id(String comment_like_user_id) {
        this.comment_like_user_id = comment_like_user_id;
    }



}
