package com.RiosTech.PlataformaDeComidaADomicilio.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String AuthHeader = request.getHeader("Authorization");
            String token = null;
            String userName = null;

            if (AuthHeader != null && AuthHeader.startsWith("bearer")){
                token = AuthHeader.substring(7);
                userName = jwtService.extractUsername(token);
        }
            //si el usuario mo esta autenticado aun
        if (userName != null && SecurityContextHolder.getContext().getAuthentication()== null){
            UserDetails userDetails = UserDetailsService.loadUserByUsername(userName);
            if (JwtService.validateToken(token, userDetails)){
                userNamePasswordAuthenticationToken authToken = new UserName;
                passwordAuthenticationToken(userDetails,null,UserDetails.getAuthorities());
                authToken.setDetails(new webAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        FilterChain.doFilter(request,response);
    }
}
