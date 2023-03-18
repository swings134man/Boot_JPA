package com.modu.tenis.jwt_server.controller;

import com.modu.tenis.jwt_server.domain.JwtRequestDTO;
import com.modu.tenis.jwt_server.domain.JwtResponseDTO;
import com.modu.tenis.jwt_server.service.JwtServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/************
 * @info : Jwt 요청 Server Controller
 * @name : JwtServerController
 * @date : 2023/03/18 4:36 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Jwt Request API Server
 ************/
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/jwt/")
public class JwtServerController {

    private final JwtServerService service;

    @PostMapping("v1/request")
    public ResponseEntity<JwtResponseDTO> loginRequest(@RequestHeader("auth-key") String header,
                                                       @RequestBody JwtRequestDTO inDTO
                             ) {
        JwtResponseDTO jwtResponseDTO = service.loginRequest(header, inDTO);

        ResponseEntity<JwtResponseDTO> result = null;

        if(jwtResponseDTO.getStatusCode().equals("200")) {
            result = ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(jwtResponseDTO);
        }else if(jwtResponseDTO.getStatusCode().equals("400")){
            result = ResponseEntity.status(400).body(jwtResponseDTO);
        }else if(jwtResponseDTO.getStatusCode().equals("401")){
            result = ResponseEntity.status(400).body(jwtResponseDTO);
        }else if(jwtResponseDTO.getStatusCode().equals("403")){
            result = ResponseEntity.status(403).body(jwtResponseDTO);
        }
        return result;
    }

}
