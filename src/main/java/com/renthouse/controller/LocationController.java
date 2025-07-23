package com.renthouse.controller;

import com.renthouse.model.Location;
import com.renthouse.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // PostMapping
    @PostMapping("/createLocation")
    public  void  saveLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }
    //  get all location
    @GetMapping("/getAll")
    public List<Location> findAllLocation(){
        return  locationService.getAllLocation();
    }

    // get by id
    @GetMapping("/getById")
    public  Location findLocationById(@PathVariable Long id){
        return  locationService.getLocationById(id);
    }
    // update location
    @PutMapping("{id}")
    public  void  updateLocation(@RequestBody Location newLocation, @PathVariable Long id){
        locationService.updateLocation(newLocation,id);
    }
    // delete location
    @DeleteMapping("{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
    }
}
