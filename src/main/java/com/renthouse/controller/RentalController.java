package com.renthouse.controller;

import com.renthouse.dto.RentalRequestDTO;
import com.renthouse.model.Rental;
import com.renthouse.service.RentalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping(value = "/create-rental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rental> addRental(@RequestBody RentalRequestDTO rentalRequestDTO) {
        Rental savedRental = rentalService.createRental(rentalRequestDTO);
        return ResponseEntity.ok(savedRental);
    }

    @GetMapping("/getAll")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    @PutMapping("/update/{id}")
    public void updateRental(@PathVariable Long id, @RequestBody RentalRequestDTO rentalRequestDTO) {
        rentalService.updateRentalById(id, rentalRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}
