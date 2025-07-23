package com.renthouse.service;

import com.renthouse.model.Location;
import com.renthouse.repository.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    //add location
    public void addLocation(Location location){
        locationRepo.save(location);
    }

    // get all
    public List<Location> getAllLocation(){
        return  locationRepo.findAll();
    }

    // get location by id

    public  Location getLocationById(Long id){
        return  locationRepo.findById(id).orElse(null);
    }

    //update
    public  void  updateLocation(Location newLocation,Long id){
        newLocation.setId(id);
        locationRepo.save(newLocation);
    }

    // delete location
    public  void  deleteLocation(Long id){
        locationRepo.deleteById(id);
    }
}
