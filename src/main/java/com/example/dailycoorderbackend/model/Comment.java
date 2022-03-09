package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long comment_id;
}
