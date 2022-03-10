package com.example.dailycoorderbackend.model;

import javax.persistence.*;
import java.io.File;


@Entity
@Table(name = "board_image")
public class Board_image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long board_image_id;

    @Column(name = "board_image_file")
    private File board_image_file;


    public Board_image() {
    }

    public Board_image(long board_image_id, File board_image_file) {
        this.board_image_id = board_image_id;
        this.board_image_file = board_image_file;
    }

    public long getBoard_image_id() {
        return board_image_id;
    }

    public void setBoard_image_id(long board_image_id) {
        this.board_image_id = board_image_id;
    }

    public File getBoard_image_file() {
        return board_image_file;
    }

    public void setBoard_image_file(File board_image_file) {
        this.board_image_file = board_image_file;
    }
}

