package com.terracustosapi.terracustos.IRepositories;

import com.terracustosapi.terracustos.Models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISessionRepository extends MongoRepository<Session, String> {
    List<Session> findByUserId(String userId);
}
