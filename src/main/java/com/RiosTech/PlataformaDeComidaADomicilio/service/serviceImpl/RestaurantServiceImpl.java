package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RestaurantDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.RestaurantDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.Restaurant;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.User;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.RestaurantMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.RestaurantRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.service.RestaurantService;
import com.RiosTech.PlataformaDeComidaADomicilio.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserService userService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, UserService userService) {
        this.restaurantRepository = restaurantRepository;
        this.userService = userService;
    }

    @Override
    public RestaurantDtoRes create(RestaurantDtoReq dto) {
        User owner = userService.findById(dto.ownerId());

        Restaurant restaurant = RestaurantMapper.toEntity(dto);
        restaurant.setOwner(owner);

        restaurantRepository.save(restaurant);

        return RestaurantMapper.toDto(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
    }
}
