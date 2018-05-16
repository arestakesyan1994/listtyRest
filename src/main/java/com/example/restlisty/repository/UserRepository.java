package com.example.restlisty.repository;

import com.example.restlisty.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findOneByEmail(String email);
}

