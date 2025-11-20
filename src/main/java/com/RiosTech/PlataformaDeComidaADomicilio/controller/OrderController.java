package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.OrderDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.OrderDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDtoRes> createOrder(@RequestBody OrderDtoReq request) {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<OrderDtoRes> acceptOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.acceptOrder(id));
    }

    @PutMapping("/{id}/assign-driver/{driverId}")
    public ResponseEntity<OrderDtoRes> assignDriver(
            @PathVariable Long id,
            @PathVariable Long driverId
    ) {
        return ResponseEntity.ok(orderService.assignDriver(id, driverId));
    }

    @PutMapping("/{id}/on-the-way")
    public ResponseEntity<OrderDtoRes> onTheWay(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.markOnTheWay(id));
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDtoRes> delivered(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.markDelivered(id));
    }
}

