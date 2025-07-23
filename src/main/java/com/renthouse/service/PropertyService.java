package com.renthouse.service;

import com.renthouse.dto.PropertyRequestDTO;
import com.renthouse.model.Location;
import com.renthouse.model.Property;
import com.renthouse.model.User;
import com.renthouse.repository.LocationRepo;
import com.renthouse.repository.PropertyRepo;
import com.renthouse.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepo propertyRepo;
    private final UserRepo userRepo;
    private  final LocationRepo locationRepo;

    public PropertyService(PropertyRepo propertyRepo, UserRepo userRepo, LocationRepo locationRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
        this.locationRepo = locationRepo;
    }

    // add property
    public Property saveProperty(PropertyRequestDTO dto){
        User landlord = userRepo.findById(dto.getLandlordId()).orElseThrow(()-> new RuntimeException("Invalid landlord ID"));
        Location location = locationRepo.findById(dto.getLocationId()).orElseThrow(()->new RuntimeException("Invalid location ID"));

        Property property = Property.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .type(dto.getType())
                .price(dto.getPrice())
                .landlord(landlord)
                .location(location)
                .build();

        return  propertyRepo.save(property);


    }

    //get all property
    public List<Property> getAllProperty(){
        return  propertyRepo.findAll();
    }

    // get property by id
    public Property getProById(Long id){
        return propertyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid landlord ID"));
    }

    // update existing  property
    public void  updateProperty(Property newProperty,Long id){
        newProperty.setId(id);
        propertyRepo.save(newProperty);
    }

    // delete existing property
    public  void  deleteProperty(Long id){
        propertyRepo.deleteById(id);
    }
}
