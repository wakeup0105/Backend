package hackerton.wakeup.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    public static String createToken(String email, String key, long expiresInSeconds) {
        Claims claims = Jwts.claims();
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiresInSeconds * 1000))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public static String createRefreshToken(String email, String key, long expiresInSeconds) {
        Claims claims = Jwts.claims();
        claims.put("email", email);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiresInSeconds * 1000))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public static Claims extractToken(String token, String secretKey) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getEmail(String token, String secretKey) {
        return extractToken(token, secretKey).get("email").toString();
    }

    public static boolean isExpired(String token, String secretKey) {
        return extractToken(token, secretKey).getExpiration().before(new Date());
    }
}
