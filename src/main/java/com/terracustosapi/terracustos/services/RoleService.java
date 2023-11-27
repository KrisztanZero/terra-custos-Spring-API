package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.enums.Role;
import com.terracustosapi.terracustos.iRepositories.IRoleRepository;
import com.terracustosapi.terracustos.interfaces.IRoleService;
import com.terracustosapi.terracustos.models.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public UserRoles getUserRoles(String userId) {
        return roleRepository.findById(userId).orElseThrow();
    }

    @Override
    public UserRoles addRoles(List<Role> roles, String userId) {
        UserRoles userRoles = new UserRoles(userId, roles);
        return roleRepository.save(userRoles);
    }
}
