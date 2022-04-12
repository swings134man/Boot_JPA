package com.modu.tenis.entity;

import lombok.*;

import javax.persistence.*;

/************
* @info : Entity class
* @name : Faq
* @date : 2022/04/12 11:11 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentNo")
    private Long contentNo;

    private String title;

    private String content;

    private String custId;
}
