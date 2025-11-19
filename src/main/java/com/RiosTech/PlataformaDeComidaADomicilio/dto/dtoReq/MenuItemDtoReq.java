package com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq;

public record MenuItemDtoReq(     String name,
         float price,
         String description,
         Long restaurantId) {
}
