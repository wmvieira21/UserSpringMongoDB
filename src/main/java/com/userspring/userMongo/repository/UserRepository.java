package com.userspring.userMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userspring.userMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
