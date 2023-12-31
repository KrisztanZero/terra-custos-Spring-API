package com.terracustosapi.terracustos.IRepositories;

import com.terracustosapi.terracustos.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    @Query("{'username': ?0 }")
    Optional<User> findByUsername(String username);

    @Query("{'email': ?0 }")
    Optional<User> findByEmail(String username);
}
