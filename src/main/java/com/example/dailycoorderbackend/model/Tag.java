package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tag_id")
  private long tag_id;

  @Column(name = "board_id")
  private long board_id;

  @Column(name = "board_image_id")
  private  long board_image_id;

  @Column(name="tag_name")
  private String tag_name;

  public Tag(){}

  public Tag(long tag_id, long board_id, long board_image_id, String tag_name) {
    this.tag_id = tag_id;
    this.board_id = board_id;
    this.board_image_id = board_image_id;
    this.tag_name = tag_name;
  }

  public long getTag_id() {
    return tag_id;
  }

  public void setTag_id(long tag_id) {
    this.tag_id = tag_id;
  }

  public long getBoard_id() {
    return board_id;
  }

  public void setBoard_id(long board_id) {
    this.board_id = board_id;
  }

  public long getBoard_image_id() {
    return board_image_id;
  }

  public void setBoard_image_id(long board_image_id) {
    this.board_image_id = board_image_id;
  }

  public String getTag_name() {
    return tag_name;
  }

  public void setTag_name(String tag_name) {
    this.tag_name = tag_name;
  }
}
