package com.logistics.tracking.service;

import com.logistics.tracking.dto.TrackingDto;
import com.logistics.tracking.entity.TrackingRequest;

public interface ITrackingService {


    /**
     *
     * @param TrackingRequest - TrackingRequest Object
     * @return TRackingDto - Response Structure including time
     */
    TrackingDto createTrackingId(TrackingRequest trackingRequest);

}
