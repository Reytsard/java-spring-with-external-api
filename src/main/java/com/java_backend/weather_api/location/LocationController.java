package com.java_backend.weather_api.location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @Value("${weather.key}")
    private String key;
    

    //todo
    @GetMapping("search")
    public void getMethodName(@RequestParam("q") String location) {
        // return new LocationService.searchLocation(location);
    }
    
}
