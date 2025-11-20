package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.UserDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.UserDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDtoRes> create(@RequestBody UserDtoReq request) {
        return ResponseEntity.ok(userService.create(request));
    }
}
