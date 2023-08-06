package com.userspring.userMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userspring.userMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
