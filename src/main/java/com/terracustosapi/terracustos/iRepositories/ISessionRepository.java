package com.terracustosapi.terracustos.iRepositories;

import com.terracustosapi.terracustos.models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends MongoRepository<Session, String> {
}
