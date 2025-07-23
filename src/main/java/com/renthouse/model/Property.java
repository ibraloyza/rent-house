package com.renthouse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.renthouse.enums.Category;
import com.renthouse.enums.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "properties")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    @JsonBackReference
    private Location location;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    // Each property belongs to one landlord (user)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landlord_id",nullable = true)
    @JsonBackReference
    private  User landlord;

    // Relationships: A property may have multiple rentals
    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Rental> rentals;

}
