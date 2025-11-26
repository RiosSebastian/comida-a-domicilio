package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.LocationDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocationTrackingService {

    // Mapa en memoria para guardar la ubicación de cada repartidor
    // Key: id del repartidor | Value: última ubicación reportada
    private final Map<Long, LocationDto> locations = new ConcurrentHashMap<>();

    // Actualiza la ubicación (llamado por el repartidor)
    public void updateLocation(LocationDto dto) {
        locations.put(dto.getDriverId(), dto);
    }

    // Devuelve la ubicación del repartidor cuando el cliente la consulta
    public LocationDto getLocation(Long driverId) {
        return locations.get(driverId);
    }
}

