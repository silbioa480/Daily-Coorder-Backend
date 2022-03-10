package com.example.dailycoorderbackend.model;


import javax.persistence.*;

@Table(name = "comment_like")

class Comment_like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "comment_like_id")
    private long comment_like_id;

    @Column(name = "comment_id")
    private String comment_id;

    @Column(name = "comment_like_user_id")
    private String comment_like_user_id;

    @Column(name = "board_image_id")
    private long board_image_id;

    public Comment_like(long comment_like_id, String comment_id, String comment_like_user_id, long board_image_id) {
        this.comment_like_id = comment_like_id;
        this.comment_id = comment_id;
        this.comment_like_user_id = comment_like_user_id;
        this.board_image_id = board_image_id;
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

    public long getBoard_image_id() {
        return board_image_id;
    }

    public void setBoard_image_id(long board_image_id) {
        this.board_image_id = board_image_id;
    }
}
