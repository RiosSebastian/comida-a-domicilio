package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import lombok.Data;

@Data
public class LocationDto {
    private Long driverId; // ID del repartidor
    private double lat;    // Latitud
    private double lon;    // Longitud
}

