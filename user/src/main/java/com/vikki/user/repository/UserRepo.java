package com.vikki.user.repository;

import com.vikki.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
