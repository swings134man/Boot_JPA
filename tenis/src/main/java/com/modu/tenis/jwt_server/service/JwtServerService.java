package com.modu.tenis.jwt_server.service;

import com.modu.tenis.jwt_server.domain.JwtRequestDTO;
import com.modu.tenis.jwt_server.domain.JwtResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/************
 * @info : Jwt 요청 Server Service
 * @name : JwtServerService
 * @date : 2023/03/18 4:37 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : Jwt Request API Server
 ************/
@Service
@RequiredArgsConstructor
@Slf4j
public class JwtServerService {

    private static String SECRET_KEY = Base64.getEncoder()
            .encodeToString("JwtServerAPItestSecretKEY".getBytes());


    public JwtResponseDTO loginRequest(String header, JwtRequestDTO inDTO) {
        JwtResponseDTO outDTO = new JwtResponseDTO();
        System.out.println(inDTO);

        // BODY : id, pw Validation (null)
        if(inDTO.getUserId() == null || inDTO.getUserPw() == null) {
            outDTO.setMsg("userId or userPW == null");
            outDTO.setStatusCode("400");
            return outDTO;

        }else if(!header.equals("testUser")) {
            // Request Header 검증
            // auth-key = testUser 이어야함. - Test Key - 추후 DB 값을 통해 인증된 API key 검증
            outDTO.setStatusCode("403");
            return outDTO;

        }else if(!(inDTO.getUserId().equals("test") && inDTO.getUserPw().equals("1234"))) {
            // Login 검증 -> TODO :DB 조회 값으로 검증할것.
            outDTO.setMsg("userId 혹은 userPw 틀렸음.");
            outDTO.setStatusCode("400");
            return outDTO;

        }else {
            // AT, RT making Logic
            Map<String, String> tokenMap = generateToken(inDTO);

            // Return Value Set
            outDTO.setAccessToken(tokenMap.get("access_token"));
            outDTO.setRefreshToken(tokenMap.get("refresh_token"));
            outDTO.setUserId(inDTO.getUserId());
            outDTO.setMsg("Token 생성 완료");
            outDTO.setStatusCode("200");
            outDTO.setExpireTime("30Sec");
            outDTO.setToken_type("bearer");
        }

        return outDTO;
    }// request v1



    // --------

    /**
     * Token 생성 Methods
     * @param inDTO
     * @return
     */
    private Map<String, String> generateToken(JwtRequestDTO inDTO) {
        Map<String, String> result = new HashMap<>();

        Date now = new Date();
        Claims claims = Jwts.claims();
        claims.put("userId", inDTO.getUserId());
        claims.put("userPw", inDTO.getUserPw());

        // JWT Create
        String access_token = Jwts.builder()
                .setSubject(inDTO.getUserId())
                .addClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date((now.getTime() + Duration.ofSeconds(30).toMillis()))) // 만료시간 = 30초
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        result.put("access_token", access_token);

        // TODO : Refresh Token ADD

        return result;
    }

}//class
