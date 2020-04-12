package br.com.milvusartis.ecommerce.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jw3.secret}")
    private String secret;

    @Value("${jw3.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public Boolean tokenValido(String token) {
        Claims claims = getClaims(token);

        //Ele conseguiu pegar os clains do token
        if (claims != null) {

            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            //Tem usuario e Data e o instante atual é anterior a data de expiração
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true;
            }
        }
        return false;

    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);


        if (claims != null) {
           return claims.getSubject();
        }
        return null;
    }

    //Método que reinvidinca Usuário e Tempo de Expiração
    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}

