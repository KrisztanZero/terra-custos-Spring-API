package com.terracustosapi.terracustos.IRepositories;

import com.terracustosapi.terracustos.Models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends MongoRepository<Session, String> {
}
