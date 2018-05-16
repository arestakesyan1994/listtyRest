package com.example.restlisty.repository;

import com.example.restlisty.model.Listty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListtyRepository extends MongoRepository<Listty,String> {

}
