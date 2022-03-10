package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Table(name = "board")
public class Board {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private long board_id;

  @Column(name = "board_poster")
  private String board_poster;

  @Column(name = "board_image")
  private int board_image;

  @Column(name = "board_title")
  private String board_title;

  @Column(name = "board_content")
  private String board_content;

  @Column(name = "board_url")
  private String board_url;

  @Column(name = "board_like_num")
  private String board_like_num;


  @Column(name = "board_view")
  private int board_view;

  @Column(name = "board_post_date")
  private int board_post_date;

  @Column(name = "board_update_date")
  private int board_update_date;

  public Board(){}

  public Board(long board_id, String board_poster, int board_image, String board_title, String board_content, String board_url, String board_like_num, int board_view, int board_post_date, int board_update_date) {
    this.board_id = board_id;
    this.board_poster = board_poster;
    this.board_image = board_image;
    this.board_title = board_title;
    this.board_content = board_content;
    this.board_url = board_url;
    this.board_like_num = board_like_num;
    this.board_view = board_view;
    this.board_post_date = board_post_date;
    this.board_update_date = board_update_date;
  }

  public long getBoard_id() {
    return board_id;
  }

  public void setBoard_id(long board_id) {
    this.board_id = board_id;
  }

  public String getBoard_poster() {
    return board_poster;
  }

  public void setBoard_poster(String board_poster) {
    this.board_poster = board_poster;
  }

  public int getBoard_image() {
    return board_image;
  }

  public void setBoard_image(int board_image) {
    this.board_image = board_image;
  }

  public String getBoard_title() {
    return board_title;
  }

  public void setBoard_title(String board_title) {
    this.board_title = board_title;
  }

  public String getBoard_content() {
    return board_content;
  }

  public void setBoard_content(String board_content) {
    this.board_content = board_content;
  }

  public String getBoard_url() {
    return board_url;
  }

  public void setBoard_url(String board_url) {
    this.board_url = board_url;
  }

  public String getBoard_like_num() {
    return board_like_num;
  }

  public void setBoard_like_num(String board_like_num) {
    this.board_like_num = board_like_num;
  }

  public int getBoard_view() {
    return board_view;
  }

  public void setBoard_view(int board_view) {
    this.board_view = board_view;
  }

  public int getBoard_post_date() {
    return board_post_date;
  }

  public void setBoard_post_date(int board_post_date) {
    this.board_post_date = board_post_date;
  }

  public int getBoard_update_date() {
    return board_update_date;
  }

  public void setBoard_update_date(int board_update_date) {
    this.board_update_date = board_update_date;
  }
}
