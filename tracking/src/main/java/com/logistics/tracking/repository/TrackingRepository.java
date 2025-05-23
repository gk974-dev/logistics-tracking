package com.logistics.tracking.repository;

import com.logistics.tracking.entity.TrackingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends MongoRepository<TrackingRequest,String> {

}
