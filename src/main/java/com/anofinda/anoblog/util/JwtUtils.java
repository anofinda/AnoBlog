package com.anofinda.anoblog.util;

import com.anofinda.anoblog.config.JwtConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

/**
 * @author dongyudeng
 */
@Slf4j
@Component
public class JwtUtils {

    private static JwtConfiguration jwtConfiguration;

    @Autowired
    public void setJwtConfiguration(JwtConfiguration jwtConfiguration) {
        JwtUtils.jwtConfiguration = jwtConfiguration;
    }

    public static String getToken(String username) {
        Key key = Keys.hmacShaKeyFor(jwtConfiguration.getSecret().getBytes(StandardCharsets.UTF_8));
        Date nowDate = new Date(System.currentTimeMillis());
        Date expireDate = new Date(nowDate.getTime() + jwtConfiguration.getExpire() * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setAudience(username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }

    public static Claims getClaims(String token) {
        Key key = Keys.hmacShaKeyFor(jwtConfiguration.getSecret().getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean verify(String token, String username) {
        Key key = Keys.hmacShaKeyFor(jwtConfiguration.getSecret().getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getAudience()
                .equals(username);

    }

    public static boolean isExpired(Date expire) {
        return expire.before(new Date());
    }
}
