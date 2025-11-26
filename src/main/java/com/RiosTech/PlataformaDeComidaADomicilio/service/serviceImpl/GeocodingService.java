package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GeocodingService {

    //permite hacer llamadas HTTP a APIs externas
    private final RestTemplate restTemplate = new RestTemplate();

    // Convierte la dirección en coordenadas
    public Map<String, Double> geocode(String address) {

        // URL del servicio de geocodificación de OpenStreetMap (Nominatim)
        String url = "https://nominatim.openstreetmap.org/search?format=json&q=" + address;

        // Llama al GET que devuelve una lista de posibles resultados
        ResponseEntity<List<Map<String, Object>>> response =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});

        // Si no hay resultados, lanza error
        if (response.getBody() == null || response.getBody().isEmpty()) {
            throw new RuntimeException("No se encontraron coordenadas para la dirección.");
        }

        // Toma el primer resultado
        Map<String, Object> result = response.getBody().get(0);

        // Retorna las coordenadas en un mapa
        return Map.of(
                "lat", Double.parseDouble((String) result.get("lat")),
                "lon", Double.parseDouble((String) result.get("lon"))
        );
    }
}
