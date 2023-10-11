package com.terracustosapi.terracustos.IRepositories;

import com.terracustosapi.terracustos.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, Long> {
    @Query("{'userName': ?0 }")
    User findByUserName(String userName);

    @Query("{'email': ?0 }")
    User findByEmail(String userName);
}