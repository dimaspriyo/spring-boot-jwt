package com.example.demo.filter;

import com.example.demo.services.UserService;
import com.example.demo.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String uri = httpServletRequest.getRequestURI();

        if(uri.equals("/api/registration") || uri.equals("/api/login")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }

        String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader.isEmpty() || !authorizationHeader.startsWith("Bearer ")) {
            throw new JwtException("Token Invalid");
        }

        String token = authorizationHeader.substring(7);
        if (jwtUtil.isValid(token, userService)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            throw new JwtException("Token Invalid");
        }
    }


}
