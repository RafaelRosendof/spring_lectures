package com.SistemLoja.SistemaLoja.Security;

import java.util.Date;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JwtUtil {

    
    //private final String secreta = "FalaFigas";
    private final Key secreta = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 5000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secreta) // can be with 512 to 
                .compact();
    }

    public String extractUser(String token){
        return Jwts.parser().setSigningKey(secreta).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secreta).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
