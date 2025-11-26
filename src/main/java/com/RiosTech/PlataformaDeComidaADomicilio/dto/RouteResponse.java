package com.RiosTech.PlataformaDeComidaADomicilio.dto;

import lombok.Data;

@Data
public class RouteResponse {
    private double distanceMeters;  // Distancia total del recorrido (en metros)
    private double durationSeconds; // Duración estimada del viaje (en segundos)
}
