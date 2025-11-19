package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;
import lombok.Builder;

@Builder
public record MenuItemDtoRes(Long id,
                             String name,
                             float price,
                             String description
                             ) {
}
