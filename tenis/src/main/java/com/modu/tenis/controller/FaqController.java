package com.modu.tenis.controller;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.service.FaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FaqController {

    private final FaqService faqService;

    @PostMapping("faq/board/v1/insert")
    public String insert(Faq faq) {

        System.out.println(faq.getTitle());
        System.out.println("테스트 : " + faq);

        faqService.insert(faq);

        return "index";
    }


}