package az.xeyale.balance.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);  // Güclü bir açar yaradılır

    // JWT tokenini başlıqdan alırıq
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");  // Tokeni Authorization başlığından alırıq
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);  // Bearer sözcüyündən sonra gələn tokeni qaytarırıq
        }
        return null;
    }

    // Tokeni doğrulamaq üçün metod
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);  // Tokeni doğrulayırıq
            return true;
        } catch (Exception e) {
            return false;  // Əgər doğrulama uğursuz olarsa, false qaytarırıq
        }
    }

    // Tokenin içindən istifadəçi adını çıxarmaq üçün metod
    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    // Yeni bir JWT tokeni yaratmaq üçün metod
    public String generateToken(String username) {
        long expirationTimeMs = 1000 * 60 * 60;  // 1 saatlıq keçərlilik müddəti
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMs))
                .signWith(key)
                .compact();
    }
}
