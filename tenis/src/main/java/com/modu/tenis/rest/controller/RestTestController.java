package com.modu.tenis.rest.controller;

import com.modu.tenis.rest.dto.ReqUserDTO;
import com.modu.tenis.rest.service.RestTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************
 * @info : Spring Rest Template Server side Controller
 * @name : RestTestController
 * @date : 2023/03/12 11:25 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : IntelliJ Project - boot-prac 에서 사용.
 ************/
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/server/")
public class RestTestController {

    private final RestTestService service;

    // get 1
    @GetMapping("get1")
    public String getTest1() {
        log.info("getTest1 호출됨");
        return "Hello this is getTest1() - serverSide";
    }

    // get2
    @GetMapping("name")
    public String getTest2(@RequestParam String name) {
        log.info("getTest2 호출! param={}", name);
        return "getTest2() = " + name;
    }

    // get3
    @GetMapping("path/{name}")
    public String name(@PathVariable String name) {
        log.info("getTest3 호출! param={}", name);
        return "getTeset3() = " + name;
    }

    // ---------------------------- post ----------------------------
    @PostMapping("user")
    public ResponseEntity<ReqUserDTO> getUser(@RequestBody ReqUserDTO dto,
                                              @RequestParam String id,
                                              @RequestParam String name) {

        log.info("post getUser() 호출!");
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


    // addHeader = Header 추가
    @PostMapping("addHeader")
    public ResponseEntity<ReqUserDTO> addHeader(@RequestHeader("server-header") String header, @RequestBody ReqUserDTO dto) {
        log.info("addHeader() Body = {}", dto);
        log.info("addHeader() header = {}", header);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
