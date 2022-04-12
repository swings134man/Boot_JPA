package com.modu.tenis.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contentNo;

    private String title;

    private String content;

    private String custId;
}
