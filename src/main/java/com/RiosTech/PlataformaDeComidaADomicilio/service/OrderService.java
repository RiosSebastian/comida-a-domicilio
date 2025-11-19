package com.RiosTech.PlataformaDeComidaADomicilio.service;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.OrderDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.OrderDtoReq;

public interface OrderService {
    OrderDtoRes createOrder(OrderDtoReq dto);
    OrderDtoRes acceptOrder(Long orderId);
    OrderDtoRes assignDriver(Long orderId, Long driverId);
    OrderDtoRes markOnTheWay(Long orderId);
    OrderDtoRes markDelivered(Long orderId);
}
