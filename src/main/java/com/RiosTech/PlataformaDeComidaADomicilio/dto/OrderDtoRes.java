package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.OrderItem;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import com.RiosTech.PlataformaDeComidaADomicilio.util.OrderStatus;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderDtoRes(Long id,
                           UserDtoRes client,
                          RestaurantDtoRes restaurant,
                          List<OrderItemDtoRes> items,
                          OrderStatus status,
                          UserDtoRes driver,
                          String deliveryAddress) {
}
