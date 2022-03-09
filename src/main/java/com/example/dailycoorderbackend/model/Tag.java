package com.example.dailycoorderbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long tag_id;
}
