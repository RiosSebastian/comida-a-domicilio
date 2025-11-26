package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RouteResponse;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

@Service
public class RouteService {

    // API Key del servicio OpenRouteService (la definís en application.properties)
    @Value("${ors.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    // Método para obtener la ruta entre coordenadas iniciales y destino
    public RouteResponse getRoute(double startLat, double startLon, double endLat, double endLon) {

        // URL del servicio de rutas por carretera
        String url = "https://api.openrouteservice.org/v2/directions/driving-car";

        // Definimos los headers necesarios: API key + JSON
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Cuerpo de la petición en formato JSON
        String body = """
            {
              "coordinates": [
                [%f, %f],
                [%f, %f]
              ]
            }
            """.formatted(startLon, startLat, endLon, endLat);

        // Construimos la petición HTTP
        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // Hacemos POST al API y recibimos la ruta
        Map<String, Object> res = restTemplate.postForObject(url, entity, Map.class);

        // Extraemos los datos de la respuesta JSON
        List features = (List) res.get("features");
        Map first = (Map) features.get(0);
        Map properties = (Map) first.get("properties");
        Map summary = (Map) properties.get("summary");

        // Construimos el DTO con distancia y tiempo de la ruta
        RouteResponse response = new RouteResponse();
        response.setDistanceMeters(Double.parseDouble(summary.get("distance").toString()));
        response.setDurationSeconds(Double.parseDouble(summary.get("duration").toString()));

        return response;
    }
}
