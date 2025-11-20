package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.MenuItemDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.MenuItemDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")

public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<MenuItemDtoRes> create(@RequestBody MenuItemDtoReq request) {
        return ResponseEntity.ok(menuItemService.create(request));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItemDtoRes>> getByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuItemService.findByRestaurant(restaurantId));
    }
}
