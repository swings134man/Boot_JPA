package com.modu.tenis.jwt_server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/************
 * @info : Jwt Request DTO
 * @name : JwtRequestDTO
 * @date : 2023/03/18 4:38 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestDTO {

    private String userId;
    private String userPw;
}
