package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;
    
    @Column(name = "card_img")
    private String card_img;
    
    @Column(name = "age")
    private int age;
    
    @Column(name = "job")
    private String job;
    
    @Column(name = "introduce")
    private String introduce;
    
    @Column(name = "sex")
    private int sex;
    
    @Column(name = "state", nullable=true)
    private Integer state;
    
    @Column(name = "team")
    private int team;
    
    @Column(name = "series")
    private int series;

}