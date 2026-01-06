package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.RouteResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Map;

@Service
public class RouteService {

    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public RouteResponse getRoute(double startLat, double startLon,
                                  double endLat, double endLon) {

        String url = "https://api.openrouteservice.org/v2/directions/driving-car";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = """
            {
              "coordinates": [
                [%f, %f],
                [%f, %f]
              ]
            }
            """.formatted(startLon, startLat, endLon, endLat);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        Map<String, Object> res =
                restTemplate.postForObject(url, entity, Map.class);

        List features = (List) res.get("features");
        Map first = (Map) features.get(0);
        Map properties = (Map) first.get("properties");
        Map summary = (Map) properties.get("summary");

        RouteResponse response = new RouteResponse();
        response.setDistanceMeters(
                Double.parseDouble(summary.get("distance").toString())
        );
        response.setDurationSeconds(
                Double.parseDouble(summary.get("duration").toString())
        );

        return response;
    }
}
