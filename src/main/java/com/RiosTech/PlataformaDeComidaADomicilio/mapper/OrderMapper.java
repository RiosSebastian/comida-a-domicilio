package com.RiosTech.PlataformaDeComidaADomicilio.mapper;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.OrderDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.OrderDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Order;

public class OrderMapper {

    public static OrderDtoRes toDto(Order entity) {
        if (entity == null) return null;

        return OrderDtoRes.builder()
                .id(entity.getId())
                .client(UserMapper.toDto(entity.getClient()))
                .restaurant(RestaurantMapper.toDto(entity.getRestaurant()))
                .driver(UserMapper.toDto(entity.getDriver()))
                .deliveryAddress(entity.getDeliveryAddress())
                .status(entity.getStatus())
                .items(
                        entity.getItems() != null ?
                                entity.getItems().stream()
                                        .map(OrderItemMapper::toDto)
                                        .toList()
                                : null
                )
                .build();
    }

    public static Order toEntity(OrderDtoReq request) {
        if (request == null) return null;

        return Order.builder()
                .deliveryAddress(request.deliveryAddress())
                .build();
    }
}
