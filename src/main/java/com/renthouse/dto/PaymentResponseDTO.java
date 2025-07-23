package com.renthouse.dto;

import com.renthouse.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Double amount;
    private LocalDate paymentDate;
    private PaymentStatus status;
    private String paymentMethod;
    private String referenceId;

    private Long rentalId;
    private Long tenantId;
    private Long propertyId;
}
