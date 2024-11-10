package az.xeyale.balance.filter;

import az.xeyale.balance.security.JwtUtil;
import az.xeyale.balance.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);  // Tokeni alırıq
        if (token != null && jwtUtil.validateToken(token)) {  // Token doğrulama
            SecurityContextHolder.getContext().setAuthentication(userService.getAuthentication(token));  // Authentication yaratmaq
        }
        filterChain.doFilter(request, response);  // Filteri növbəti filterə yönləndiririk
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // "Bearer " hissəsini kəsirik
        }
        return null;
    }
}
