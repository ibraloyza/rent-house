package com.renthouse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.renthouse.enums.RentalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each rental is for one tenant (User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    @JsonManagedReference
    private User tenant;

    //Each rental is for one property
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    @JsonManagedReference
    private Property property;

    @Column(nullable = false)
    private LocalDate startDate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus status;  // PENDING, APPROVED, REJECTED
}
