package com.java_backend.weather_api.location;

import com.java_backend.weather_api.model.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class LocationService {

    @Value("${weather.key}")
    private String key;

    public RestClient restClient;

    public LocationService(RestClient restClient){
        this.restClient = restClient;
    }

    public List<WeatherApiResponse.Location> fetchLocations(String locationQuery){
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/search.json")
                                .queryParam("key",key)
                                .queryParam("q",locationQuery)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<List<WeatherApiResponse.Location>>() {}); //or if its a class we can use the .class method
    }
}
