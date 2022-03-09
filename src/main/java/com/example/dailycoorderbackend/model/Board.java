package com.example.dailycoorderbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long board_id;

//  @Column(name = "board_poster")
//  private User board_poster;
//
//  @Column(name = "board_img")
//  private Image board_img;
//
//  @Column(name = "board_tag")
//  private Tag[] board_tag;
//
//  @Column(name = "board_comment")
//  private Comment[] board_comment;

  @Column(name = "board_text")
  private String board_text;

  @Column(name = "board_date")
  private Date board_date;

  @Column(name = "board_like")
  private int board_like;

  @Column(name = "board_view")
  private int board_view;
}
