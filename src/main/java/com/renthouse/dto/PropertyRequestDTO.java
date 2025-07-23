package com.renthouse.dto;

import com.renthouse.enums.Category;
import com.renthouse.enums.PropertyType;
import lombok.Data;

@Data
public class PropertyRequestDTO {
    private String title;
    private String description;
    private Category category;
    private PropertyType type;
    private float price;
    private Long landlordId;
    private Long locationId;
}
