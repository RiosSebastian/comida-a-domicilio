package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import lombok.Builder;

@Builder
public record OrderItemDtoRes(Long id,
                              MenuItemDtoRes menuItem,
                              int quantity
                              ) {
}
