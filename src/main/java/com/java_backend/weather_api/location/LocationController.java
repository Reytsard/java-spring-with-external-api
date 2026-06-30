package com.java_backend.weather_api.location;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java_backend.weather_api.model.WeatherApiResponse;


@RestController
@RequestMapping("location")
public class LocationController {


    
    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    

    //todo
    @GetMapping("search")
    public ResponseEntity<List<WeatherApiResponse.Location>> getMethodName(@RequestParam("location") String location) {
        return ResponseEntity.ok(locationService.fetchLocations(location));
    }
    
}
