package com.terracustosapi.terracustos.iRepositories;

import com.terracustosapi.terracustos.models.UserRoles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends MongoRepository<UserRoles, String> {
}
