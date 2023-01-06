package com.vacinas.config.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {
    final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try{
        String jwtToken = extractJwtFromRequest(request);

        if (StringUtils.hasText(jwtToken) && jwtUtil.validateToken(jwtToken)) {
            UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(jwtToken), "",
                    jwtUtil.getRolesFromToken(jwtToken));

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {

            logger.warn("Não foi possível definir o contexto de segurança");
        }
        }catch(ExpiredJwtException | BadCredentialsException ex)
        {
            request.setAttribute("exception", ex);
        }
        chain.doFilter(request, response);
    }
    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
