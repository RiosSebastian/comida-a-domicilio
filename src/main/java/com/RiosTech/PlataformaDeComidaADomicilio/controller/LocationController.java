package com.RiosTech.PlataformaDeComidaADomicilio.controller;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.LocationDto;
import com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl.LocationTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {

    //guarda y gestiona ubicaciones
    private final LocationTrackingService trackingService;

    //para actualizar la ubicación del repartidor
    @PostMapping("/update")
    public ResponseEntity<Void> updateLocation(@RequestBody LocationDto dto) {
        trackingService.updateLocation(dto);
        return ResponseEntity.ok().build();
    }

    //para obtener la última ubicación de un repartidor
    @GetMapping("/{driverId}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Long driverId) {
        return ResponseEntity.ok(trackingService.getLocation(driverId));
    }
}
