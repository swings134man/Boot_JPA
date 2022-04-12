package com.modu.tenis.repository;

import com.modu.tenis.entity.Faq;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/************
* @info : repository class
* @name : FaqRepository
* @date : 2022/04/12 11:11 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Repository
public interface FaqRepository extends JpaRepository<Faq , Long> {

    Faq findByContentNo (Long contentNo); // 게시물 번호로 row 조회.

    List<Faq> findAll();    // 전체조회
}
