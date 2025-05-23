package com.logistics.tracking.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Document(collection = "trackingids")
public class TrackingRequest {

    @NotNull(message = "Customer Id cannot be null. Please provide a valid id")
    private UUID customer_id;

    @NotEmpty(message = "Origin country ID is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Origin country ID must be in ISO 3166-1 alpha-2 format")
    private String origin_country_id;

    @NotEmpty(message = "Destination country ID is required")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Destination country ID must be in ISO 3166-1 alpha-2 format")
    private String destination_country_id;

    @NotNull(message = "Weight is required")
    @Digits(integer = 7, fraction = 3, message = "Weight must have up to 3 decimal places")
    @DecimalMin(value = "0.001", inclusive = true, message = "Weight must be greater than 0")
    private BigDecimal weight;

    private String created_at;

    @NotEmpty(message = "Customer name is required")
    private String customer_name;

    @Pattern(
            regexp = "^[a-z0-9]+(-[a-z0-9]+)+$",
            message = "Customer slug must be in slug-case (lowercase letters, numbers, and hyphens only)"
    )
    private String customer_slug;

    private String tracking_id;
}
