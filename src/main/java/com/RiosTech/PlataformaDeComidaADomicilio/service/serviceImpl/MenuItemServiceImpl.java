package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.MenuItemDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.MenuItemDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.MenuItem;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.MenuItemMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.MenuItemRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.service.MenuItemService;
import com.RiosTech.PlataformaDeComidaADomicilio.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantService restaurantService;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, RestaurantService restaurantService) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public MenuItemDtoRes create(MenuItemDtoReq dto) {
        Restaurant restaurant = restaurantService.findById(dto.restaurantId());

        MenuItem item = MenuItemMapper.toEntity(dto);
        item.setRestaurant(restaurant);

        menuItemRepository.save(item);
        return MenuItemMapper.toDto(item);
    }

    @Override
    public List<MenuItemDtoRes> findByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(MenuItemMapper::toDto)
                .toList();
    }
}
