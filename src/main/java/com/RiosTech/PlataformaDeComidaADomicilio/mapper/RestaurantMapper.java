package com.RiosTech.PlataformaDeComidaADomicilio.mapper;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RestaurantDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.RestaurantDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;

public class RestaurantMapper {

    public static RestaurantDtoRes toDto(Restaurant entity) {
        if (entity == null) return null;

        return RestaurantDtoRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .owner(UserMapper.toDto(entity.getOwner()))
                .build();
    }

    public static Restaurant toEntity(RestaurantDtoReq request) {
        if (request == null) return null;

        // OJO: owner debe setearse desde el service
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}

