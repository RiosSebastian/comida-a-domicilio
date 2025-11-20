package com.RiosTech.PlataformaDeComidaADomicilio.mapper;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.OrderItemDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.OrderItemDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItemDtoRes toDto(OrderItem entity) {
        if (entity == null) return null;

        return OrderItemDtoRes.builder()
                .id(entity.getId())
                .menuItem(MenuItemMapper.toDto(entity.getItem()))
                .quantity(entity.getQuantity())
                .build();
    }

    public static OrderItem toEntity(OrderItemDtoReq request) {
        if (request == null) return null;

        return OrderItem.builder()
                .quantity(request.quantity())
                .build();
    }
}
