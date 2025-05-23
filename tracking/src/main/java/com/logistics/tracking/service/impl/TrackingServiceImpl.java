package com.logistics.tracking.service.impl;

import com.logistics.tracking.dto.TrackingDto;
import com.logistics.tracking.entity.TrackingRequest;
import com.logistics.tracking.repository.TrackingRepository;
import com.logistics.tracking.service.ITrackingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class TrackingServiceImpl implements ITrackingService {

    TrackingRepository trackingRepository;
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * @param trackingRequest@return TrackingDto - Response Structure including time
     */
    @Override
    public TrackingDto createTrackingId(TrackingRequest trackingRequest) {
        OffsetDateTime dateTime = OffsetDateTime.parse(trackingRequest.getCreated_at().toString());
        trackingRequest.setTracking_id(generateTrackingNumber());
        trackingRepository.save(trackingRequest);
        TrackingDto trackingDto = new TrackingDto();
        trackingDto.setTracking_id(trackingRequest.getTracking_id());
        trackingDto.setCreated_at(OffsetDateTime.parse(dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)));
        return trackingDto;
    }

    /**
     * Generates a random string matching the pattern ^[A-Z0-9]{1,16}$
     *
     * @return A random string with 1 to 16 uppercase letters and digits
     */
    public static String generateTrackingNumber() {
        SecureRandom random = new SecureRandom();
        int length = 17; // Length between 1 and 16
        return IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length()))))
                .collect(Collectors.joining());
    }

}
