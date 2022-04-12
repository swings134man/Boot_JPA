package com.modu.tenis.service;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.repository.FaqRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/************
* @info : service class
* @name : FaqService
* @date : 2022/04/12 11:11 PM
* @author : SeokJun Kang(swings134@gmail.com)
* @version : 1.0.0
************/
@Service
@RequiredArgsConstructor
@Slf4j
public class FaqService {

    private final FaqRepository  faqRepository;

    /**
    * @info    : 게시판 글 삽입.
    * @name    : insert
    * @date    : 2022/04/12 11:09 PM 
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : Faq
    * @return  : void
    */
    public void insert(Faq faq) {
        System.out.println("service : " + faq);

        faqRepository.save(faq);
    }

    /**
    * @info    : 글번호로 row 조회
    * @name    : retrieve
    * @date    : 2022/04/12 11:10 PM 
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : Faq
    * @return  : Faq
    */
    public Faq retrieve(Faq faq)  {
//           Faq re = faqRepository.findById(faq.getContentNo()).get(); // service 에서 직접적으로 DB 접근.
//           return re;
        System.out.printf("Q@@@@@@@@@@@@@@@@@@" + faq.getContentNo());
        Faq re = faqRepository.findByContentNo(faq.getContentNo());

        if(re == null) {
            throw new IllegalArgumentException();
        }

        return re;

    }

    /**
    * @info    : 전체 게시글 조회
    * @name    : searchAll
    * @date    : 2022/04/12 11:10 PM 
    * @author  : SeokJun Kang(swings134@gmail.com)
    * @version : 1.0.0
    * @param   : 
    * @return  : List<Faq>
    */
    public List<Faq> searchAll() {
//        List<Faq> faq = faqRepository.findAll();

        List<Faq> result = faqRepository.findAll();

        return result;
    }

}
