package com.renthouse.dto;

import com.renthouse.enums.RentalStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalRequestDTO {
    private Long tenantId;
    private Long propertyId;
    private LocalDate startDate;
    private RentalStatus status;
}
