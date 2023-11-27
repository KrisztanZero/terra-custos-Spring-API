package com.terracustosapi.terracustos.interfaces;

import com.terracustosapi.terracustos.enums.Role;
import com.terracustosapi.terracustos.models.UserRoles;

import java.util.List;

public interface IRoleService {
    UserRoles getUserRoles(String userId);

    UserRoles addRoles(List<Role> roles, String userId);
}
