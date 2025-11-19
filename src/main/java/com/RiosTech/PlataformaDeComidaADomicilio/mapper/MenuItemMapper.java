package com.RiosTech.PlataformaDeComidaADomicilio.mapper;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.MenuItemDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.MenuItemDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.MenuItem;

public class MenuItemMapper {

    public static MenuItemDtoRes toDto(MenuItem entity) {
        if (entity == null) return null;

        return MenuItemDtoRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }

    public static MenuItem toEntity(MenuItemDtoReq request) {
        if (request == null) return null;

        return MenuItem.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();
    }
}

