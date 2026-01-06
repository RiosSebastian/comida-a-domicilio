package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.AuthResponse;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.LoginRequest;
import com.RiosTech.PlataformaDeComidaADomicilio.security.JwtService;
import com.RiosTech.PlataformaDeComidaADomicilio.security.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UserDetailsServiceImpl userDetailsService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request
    ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            var userDetails =
                    userDetailsService.loadUserByUsername(request.getUsername());

            String token = jwtService.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new AuthResponse(token, null));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
