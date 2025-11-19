package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import lombok.Builder;

@Builder
public record RestaurantDtoRes(Long id,
                               String name,
                               String address,
                                User owner) {
}
