package com.example.restlisty.repository;

import com.example.restlisty.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String> {

    List<Comment> findAllByUserId(String id);
}
