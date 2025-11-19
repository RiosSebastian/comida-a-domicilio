package com.RiosTech.PlataformaDeComidaADomicilio.mapper;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.UserDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.UserDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;

public class UserMapper {

    public static UserDtoRes toDto(User user) {
        if (user == null) return null;

        return UserDtoRes.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public static User toEntity(UserDtoReq request) {
        if (request == null) return null;

        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .role(request.getRole())
                .build();
    }
}

