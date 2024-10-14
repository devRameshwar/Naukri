package com.naukri.security.jwt;

import com.naukri.constant.ApplicationConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    private static final String secretKey = "Ur7bnY05K5JWIaQHvNnIVZygCuXdxzIHertyuioASDFGHJKWERTYUIRTYUIOXCVBNMFGHJKLwertyuio";

    //Token Generator using user name
    public String generateJwtToken(String userName) {
        return Jwts.builder().setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + ApplicationConstant.JWT_TOKEN_VAILIDITY)).signWith(SignatureAlgorithm.HS256, secretKey).compact();

    }

    //getUsername from token
    public String getUserNameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build().parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    //validate token with userName and time interval
    public Boolean validToken(String token, String userName) {
        final String tokenUserName = this.getUserNameFromToken(token);
        return userName.equals(tokenUserName) && !isTokenExpired(token);
    }

    //check token is expire
    public Boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expiration.before(new Date());
    }


}
