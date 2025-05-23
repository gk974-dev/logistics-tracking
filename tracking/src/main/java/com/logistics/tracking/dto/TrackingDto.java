package com.logistics.tracking.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Schema(
        name = "Tracking",
        description = "Schema to hold Tracking Id information"
)
@Data
@NoArgsConstructor
public class TrackingDto {

    private String tracking_id;
    private OffsetDateTime created_at;

}
