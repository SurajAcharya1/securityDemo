package com.example.securityDemo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailService customUserDetailService;
    private static final String REFRESH_URI_PART = "new_refresh_token_fetch";

    public JwtFilter(JwtUtil jwtUtil, CustomUserDetailService customUserDetailService) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String jwtToken = null;
        String username = null;
        String tokenType = null;

        if (!ObjectUtils.isEmpty(authHeader) && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.substring(7);
            username = jwtUtil.getUsername(jwtToken);
            tokenType = jwtUtil.getTokenType(jwtToken);
        }

        if (!ObjectUtils.isEmpty(username) &&
                ObjectUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication())) {
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
            String[] splitUri = request.getRequestURI().split("/");

            if (((splitUri[splitUri.length - 1].equals(REFRESH_URI_PART) &&
                    tokenType.equals(jwtUtil.getRefreshTokenType())) ||
                    (!splitUri[splitUri.length - 1].equals(REFRESH_URI_PART) &&
                            tokenType.equals(jwtUtil.getAccessTokenType()))) &&
                    jwtUtil.validateToken(jwtToken)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );
                SecurityContextHolder.getContext()
                        .setAuthentication(
                                usernamePasswordAuthenticationToken
                        );
            }
        }

        filterChain.doFilter(request, response);
    }
}