package az.xeyale.balance.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "your_secret_key";  // Şifrəni dəyişdirin

    // Token yaratmaq üçün metod
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 saatlıq etibarlılıq
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Tokeni doğrulamaq üçün metod
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Token-dən istifadəçi adı çıxarmaq üçün metod
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Claims-dən məlumatları çıxarmaq üçün metod
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
