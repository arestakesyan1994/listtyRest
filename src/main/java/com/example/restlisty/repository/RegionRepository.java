package com.example.restlisty.repository;

import com.example.restlisty.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region,String> {

}
