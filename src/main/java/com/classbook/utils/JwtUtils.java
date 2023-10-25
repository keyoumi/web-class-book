package com.classbook.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtUtils {
    private static final String SIGNING_KEY = "hahaha";

    public static String generateJwt(HashMap<String, Object> claims){//获取令牌
        String jwt = Jwts.builder().setClaims(claims)//自定义内容（载荷）
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)//签名算法，SIGNING_KEY为秘钥
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))//12小时有效期,
                .compact();
        System.out.println("generateJwt:" + jwt);
        return jwt;
    }

    public static Claims parseJwt(String jwtString){//解析令牌
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY)//SIGNING_KEY为秘钥
                .parseClaimsJws(jwtString)
                .getBody();
        System.out.println("parseJwt claims:" + claims);
        return claims;
    }

}
