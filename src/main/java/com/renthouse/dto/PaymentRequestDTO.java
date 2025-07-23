package com.renthouse.dto;

import com.renthouse.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PaymentRequestDTO {
    private Long rentalId;
    private Double amount;
    private LocalDate paymentDate;
    private PaymentStatus status;
    private String paymentMethod;
    private String referenceId;
}
