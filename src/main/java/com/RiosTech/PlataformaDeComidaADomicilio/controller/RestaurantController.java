package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RestaurantDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.RestaurantDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.RestaurantMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDtoRes> create(@RequestBody RestaurantDtoReq request) {
        return ResponseEntity.ok(restaurantService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDtoRes> getById(@PathVariable Long id) {
        return ResponseEntity.ok(RestaurantMapper.toDto(restaurantService.findById(id)));
    }
}

