package com.modu.tenis.controller;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.service.FaqService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/************
* @info : controller class
* @name : FaqController
* @date : 2022/04/12 11:12 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("faq/board/")
public class FaqController {

    private final FaqService faqService;

    /**
    * @info    : 게시글 insert
    * @name    : insert
    * @date    : 2022/04/12 11:12 PM
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : Faq
    * @return  : String(page)
    */
    @PostMapping("v1/insert")
    public String insert(Faq faq) {

        System.out.println(faq.getTitle());
        System.out.println("테스트 : " + faq);

        faqService.insert(faq);

        return "index";
    }

    /**
    * @info    : 전체 게시글 조회
    * @name    : searchAll
    * @date    : 2022/04/12 11:13 PM
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   :
    * @return  : List<Faq>
    */
    @GetMapping("v1/searchAll")
    public String searchAll(Model model) {

        List<Faq> out = faqService.searchAll();
//        return faq;

        model.addAttribute("list", out);

        return "faqList";
    }


}
