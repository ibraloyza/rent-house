package com.renthouse.controller;

import com.renthouse.dto.PropertyRequestDTO;
import com.renthouse.model.Property;
import com.renthouse.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/property")
public class PropertyController {
    private  final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/create-property")
    public ResponseEntity<Property> addProperty(@RequestBody PropertyRequestDTO dto){
        Property saved = propertyService.saveProperty(dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saved);

    }

    @GetMapping("/getAll")
    public List<Property> findAllProperty(){
        return propertyService.getAllProperty();
    }

    @GetMapping("/{id}")
    public  Property findPropertyById(@PathVariable Long id){
        return  propertyService.getProById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProperty(@PathVariable Long id, @RequestBody Property property) {
        propertyService.updateProperty(property, id);
        return ResponseEntity.ok("Property updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.ok("Property deleted successfully");
    }

}

