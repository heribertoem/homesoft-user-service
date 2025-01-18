package com.homeSoft.solutions.user_service.repository;

import com.homeSoft.solutions.user_service.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository <Users, String> {
    Optional<Users> findByName(String name);
}
