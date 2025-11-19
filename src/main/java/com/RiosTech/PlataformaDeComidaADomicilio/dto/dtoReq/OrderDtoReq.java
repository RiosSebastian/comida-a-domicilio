package com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq;

import java.util.List;

public record OrderDtoReq(Long clientId,
                          Long restaurantId,
                          String deliveryAddress,
                          List<OrderItemDtoReq> items) {
}
