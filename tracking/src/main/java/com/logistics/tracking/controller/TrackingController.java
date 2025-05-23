package com.logistics.tracking.controller;

import com.logistics.tracking.dto.TrackingDto;
import com.logistics.tracking.entity.TrackingRequest;
import com.logistics.tracking.service.ITrackingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class TrackingController {

    private static final Logger logger = LoggerFactory.getLogger(TrackingController.class);

    ITrackingService trackingService;

    public TrackingController(ITrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping(path = "/next-tracking-number")
    public ResponseEntity<TrackingDto> fetchTrackingId(@Valid TrackingRequest trackingRequest) {
        TrackingDto trackingDto = trackingService.createTrackingId(trackingRequest);
        return ResponseEntity.status(HttpStatus.OK).body(trackingDto);
    }

}
