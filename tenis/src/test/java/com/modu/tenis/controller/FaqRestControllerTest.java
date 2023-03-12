package com.modu.tenis.controller;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.repository.FaqRepository;
import com.modu.tenis.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FaqRestControllerTest {

    @Autowired
    FaqService service;

    @Autowired
    FaqRestController rc;

    @Test
    public void retrieve() {

        Faq f = new Faq();
        f.setContentNo(1L);

        Faq id = service.retrieve(f);


    }
}