package com.example.restlisty.repository;

import com.example.restlisty.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {

}
