package com.example.dailycoorderbackend.model;

import javax.persistence.*;


@Entity
@Table(name = "board_image")
public class BoardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long board_image_id;

    @Column(name = "board_image_file")
    private byte[] board_image_file;

    @Column(name = "board_image_type")
    private String board_image_type;

    @Column(name = "board_image_name")
    private String board_image_name;

    public BoardImage() {
    }

    public BoardImage(byte[] board_image_file, String board_image_type, String board_image_name) {
        this.board_image_file = board_image_file;
        this.board_image_type = board_image_type;
        this.board_image_name = board_image_name;
    }

    public long getBoard_image_id() {
        return board_image_id;
    }

    public void setBoard_image_id(long board_image_id) {
        this.board_image_id = board_image_id;
    }

    public byte[] getBoard_image_file() {
        return board_image_file;
    }

    public void setBoard_image_file(byte[] board_image_file) {
        this.board_image_file = board_image_file;
    }

    public String getBoard_image_type() {
        return board_image_type;
    }

    public void setBoard_image_type(String board_image_type) {
        this.board_image_type = board_image_type;
    }

    public String getBoard_image_name() {
        return board_image_name;
    }

    public void setBoard_image_name(String board_image_name) {
        this.board_image_name = board_image_name;
    }

}

