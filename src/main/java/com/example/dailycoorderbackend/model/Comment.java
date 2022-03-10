package com.example.dailycoorderbackend.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private long comment_id;

  @Column(name = "board_id")
  private long board_id;

  @Column(name = "comment_poster")
  private String comment_poster;

  @Column(name = "board_image_id")
  private long board_image_id;

  @Column(name = "comment_text")
  private String comment_text;

  @Column(name = "comment_like_number")
  private int comment_like_number;

  @Column(name = "comment_post_date")
  private Date comment_post_date;

  @Column(name = "comment_update_date")
  private Date comment_update_date;

  public Comment(){}

  public Comment(long comment_id, long board_id, String comment_poster, long board_image_id, String comment_text, int comment_like_number, Date comment_post_date, Date comment_update_date) {
    this.comment_id = comment_id;
    this.board_id = board_id;
    this.comment_poster = comment_poster;
    this.board_image_id = board_image_id;
    this.comment_text = comment_text;
    this.comment_like_number = comment_like_number;
    this.comment_post_date = comment_post_date;
    this.comment_update_date = comment_update_date;
  }

  public long getComment_id() {
    return comment_id;
  }

  public void setComment_id(long comment_id) {
    this.comment_id = comment_id;
  }

  public long getBoard_id() {
    return board_id;
  }

  public void setBoard_id(long board_id) {
    this.board_id = board_id;
  }

  public String getComment_poster() {
    return comment_poster;
  }

  public void setComment_poster(String comment_poster) {
    this.comment_poster = comment_poster;
  }

  public long getBoard_image_id() {
    return board_image_id;
  }

  public void setBoard_image_id(long board_image_id) {
    this.board_image_id = board_image_id;
  }

  public String getComment_text() {
    return comment_text;
  }

  public void setComment_text(String comment_text) {
    this.comment_text = comment_text;
  }

  public int getComment_like_number() {
    return comment_like_number;
  }

  public void setComment_like_number(int comment_like_number) {
    this.comment_like_number = comment_like_number;
  }

  public Date getComment_post_date() {
    return comment_post_date;
  }

  public void setComment_post_date(Date comment_post_date) {
    this.comment_post_date = comment_post_date;
  }

  public Date getComment_update_date() {
    return comment_update_date;
  }

  public void setComment_update_date(Date comment_update_date) {
    this.comment_update_date = comment_update_date;
  }
}
