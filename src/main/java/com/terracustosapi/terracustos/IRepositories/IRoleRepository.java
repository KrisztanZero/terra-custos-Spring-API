package com.terracustosapi.terracustos.IRepositories;

import com.terracustosapi.terracustos.Enums.Role;
import com.terracustosapi.terracustos.Models.UserRoles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends MongoRepository<UserRoles, String> {
}
