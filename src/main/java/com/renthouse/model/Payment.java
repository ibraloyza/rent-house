package com.renthouse.model;

import com.renthouse.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private  Double amount;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rental rental;

    @Column(nullable = false)
    private  String paymentMethod;

    @Column(nullable = false)
    private String referenceId;

}
