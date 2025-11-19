package com.RiosTech.PlataformaDeComidaADomicilio.service;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.MenuItemDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.MenuItemDtoReq;

import java.util.List;

public interface MenuItemService {
    MenuItemDtoRes create(MenuItemDtoReq dto);
    List<MenuItemDtoRes> findByRestaurant(Long restaurantId);
}
