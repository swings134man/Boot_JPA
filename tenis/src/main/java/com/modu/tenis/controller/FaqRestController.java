package com.modu.tenis.controller;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.service.FaqService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/************
* @info : controller class
* @name : FaqRestController
* @date : 2022/04/12 10:49 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@RestController
@RequiredArgsConstructor
@RequestMapping("api/faq/")
public class FaqRestController {
    private final FaqService faqService;


    /**
    * @info    : 게시글 번호로 row 단건 조회.
    * @name    : retrieve
    * @date    : 2022/04/12 11:11 PM
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : Faq
    * @return  : Faq
    */
    @GetMapping("v1/retrieve")
    public Faq retrieve(Faq faq) {

        Faq re = faqService.retrieve(faq);
        return re;
    }

}
