package com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq;

import lombok.Data;


public record MenuItemDtoReq( String name,
         float price,
         String description,
         Long restaurantId) {
}
