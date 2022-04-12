package com.modu.tenis.controller;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/faq/")
public class FaqRestController {
    private final FaqService faqService;

    @GetMapping("v1/retrieve")
    public Faq retrieve(Faq faq) {
        Faq re = faqService.retrieve(faq);
        return re;
    }

}
