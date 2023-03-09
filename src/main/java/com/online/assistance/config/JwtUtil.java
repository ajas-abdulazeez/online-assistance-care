package com.online.assistance.config;

import com.online.assistance.entity.UserAccounts;
import com.online.assistance.service.IClientKeyService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private IClientKeyService iClientKeyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(UserAccounts user) {

        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
                .setIssuer("CodeJava")
                .claim("roles", user.getRoles().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }
        return false;
    }

    public String getSubject(String token, String appId) {
        return parseClaims(token,appId).getSubject();
    }

    public Claims parseClaims(String token, String appId) {
        String clientSecretKey = appId.isEmpty()||appId.isBlank() ?  SECRET_KEY : iClientKeyService.getClientSecretKey(appId);
        return Jwts.parser()
                .setSigningKey(clientSecretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}