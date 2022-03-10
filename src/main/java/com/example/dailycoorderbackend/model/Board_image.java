package com.example.dailycoorderbackend.model;

import javax.persistence.*;
import java.sql.Blob;

@Table(name = "board_image")
public class Board_image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "board_image_id")
    private long board_image_id;

    @Column(name = "board-image_file")
    private Blob board_image_file;



    public Board_image() {
    }

    public Board_image(long board_image_id, Blob board_image_file) {
        this.board_image_id = board_image_id;
        this.board_image_file = board_image_file;
    }

    public long getBoard_image_id() {
        return board_image_id;
    }

    public void setBoard_image_id(long board_image_id) {
        this.board_image_id = board_image_id;
    }

    public Blob getBoard_image_file() {
        return board_image_file;
    }

    public void setBoard_image_file(Blob board_image_file) {
        this.board_image_file = board_image_file;
    }
}

