package com.RiosTech.PlataformaDeComidaADomicilio.service;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RestaurantDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.RestaurantDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;

public interface RestaurantService {
    RestaurantDtoRes create(RestaurantDtoReq dto);
    Restaurant findById(Long id);
}
