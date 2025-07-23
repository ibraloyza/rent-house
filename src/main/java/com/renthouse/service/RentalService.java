package com.renthouse.service;

import com.renthouse.dto.RentalRequestDTO;
import com.renthouse.enums.RentalStatus;
import com.renthouse.model.Property;
import com.renthouse.model.Rental;
import com.renthouse.model.User;
import com.renthouse.repository.PropertyRepo;
import com.renthouse.repository.RentalRepo;
import com.renthouse.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepo rentalRepo;
    private final UserRepo userRepo;
    private final PropertyRepo propertyRepo;

    public RentalService(RentalRepo rentalRepo, UserRepo userRepo, PropertyRepo propertyRepo) {
        this.rentalRepo = rentalRepo;
        this.userRepo = userRepo;
        this.propertyRepo = propertyRepo;
    }

    public Rental createRental(RentalRequestDTO dto) {
        User tenant = userRepo.findById(dto.getTenantId())
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
        Property property = propertyRepo.findById(dto.getPropertyId())
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));

        Rental rental = Rental.builder()
                .tenant(tenant)
                .property(property)
                .startDate(dto.getStartDate())
                .status(dto.getStatus() != null ? dto.getStatus() : RentalStatus.PENDING)
                .build();

        return rentalRepo.save(rental);
    }

    public List<Rental> getAllRentals() {
        return rentalRepo.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Rental not found"));
    }

    public void updateRentalById(Long id, RentalRequestDTO dto) {
        Rental rental = getRentalById(id);

        if (dto.getStartDate() != null)
            rental.setStartDate(dto.getStartDate());

        if (dto.getStatus() != null)
            rental.setStatus(dto.getStatus());

        if (dto.getTenantId() != null) {
            User tenant = userRepo.findById(dto.getTenantId())
                    .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));
            rental.setTenant(tenant);
        }

        if (dto.getPropertyId() != null) {
            Property property = propertyRepo.findById(dto.getPropertyId())
                    .orElseThrow(() -> new EntityNotFoundException("Property not found"));
            rental.setProperty(property);
        }

        rentalRepo.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepo.deleteById(id);
    }
}
