package com.modu.tenis.service;

import com.modu.tenis.entity.Faq;
import com.modu.tenis.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.collection.OneToManyJoinWalker;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
@Slf4j
public class FaqService {

    private final FaqRepository  faqRepository;

    public void insert(Faq faq) {
        System.out.println("service : " + faq);

        faqRepository.save(faq);
    }

    public Faq retrieve(Faq faq)  {
           Faq re = faqRepository.findById(faq.getContentNo()).get();
           return re;
    }

    public String excep() {
        String msg = "조회결과 없음.";
        return msg;
    }

}
