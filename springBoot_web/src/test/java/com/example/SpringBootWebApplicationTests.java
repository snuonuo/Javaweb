package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringBootWebApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成JWT令牌
     */
    @Test
    public void generateJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima") // 签名算法
                .addClaims(claims) // 自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT令牌
     */
    @Test
    public void parseJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcwMDY1NDAxMH0.8AWhmBhcijamAsHP-qhrV-mAXVPWKebsWQsvL7lMfU8")
                .getBody();
        System.out.println(claims);
    }

}
