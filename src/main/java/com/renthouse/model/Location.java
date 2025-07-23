package com.renthouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "locations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private  String district;
    @Column(nullable = false)
    private  String city;
    @Column(nullable = false)
    private  String address;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Property> properties;
}
