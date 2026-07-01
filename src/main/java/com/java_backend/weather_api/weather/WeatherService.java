package com.java_backend.weather_api.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.java_backend.weather_api.model.WeatherApiResponse;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private RestClient restClient;

    @Value("${weather.key}")
    private String key;

    public WeatherService(RestClient restClient){
        this.restClient = restClient;
    }

    public WeatherApiResponse getLatestWeatherByDegree(double lat, double lon){
        System.out.println("key: "+key+" latlon: "+lat+","+lon);
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("current.json")
                                .queryParam("key",key)
                                .queryParam("q",lat+","+lon)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<WeatherApiResponse>(){});
    }

    public WeatherApiResponse getLatestWeatherByLocation(String location) {
        System.out.println("key: "+key+" loc: "+location);
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/current.json")
                                .queryParam("key",key)
                                .queryParam("q",location)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<WeatherApiResponse>(){});
    }
}
   
