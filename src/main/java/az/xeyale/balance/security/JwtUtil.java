package az.xeyale.balance.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key";  // Şifrəni özünüz təyin edin

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
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);  // Tokeni doğrulayırıq
            return true;
        } catch (Exception e) {
            return false;  // Əgər doğrulama uğursuz olarsa, false qaytarırıq
        }
    }

    // Tokenin içindən istifadəçi adını çıxarmaq üçün metod
    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    // Token yaratmaq üçün metod (optional)
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
