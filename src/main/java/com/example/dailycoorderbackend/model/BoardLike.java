package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "board_like")
public class BoardLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long board_like_id;

    @Column(name = "board_id")
    private long board_id;

    @Column(name = "board_like_user_id")
    private String board_like_user_id;


    public BoardLike() {
    }

    public BoardLike(long board_like_id, long board_id, String board_like_user_id) {
        this.board_like_id = board_like_id;
        this.board_id = board_id;
        this.board_like_user_id = board_like_user_id;

    }

    public long getBoard_like_id() {
        return board_like_id;
    }

    public void setBoard_like_id(long board_like_id) {
        this.board_like_id = board_like_id;
    }

    public long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(long board_id) {
        this.board_id = board_id;
    }

    public String getBoard_like_user_id() {
        return board_like_user_id;
    }

    public void setBoard_like_user_id(String board_like_user_id) {
        this.board_like_user_id = board_like_user_id;
    }


}
