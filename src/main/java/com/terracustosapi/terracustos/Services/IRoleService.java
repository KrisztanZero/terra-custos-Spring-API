package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Enums.Role;
import com.terracustosapi.terracustos.Models.UserRoles;

import java.util.List;

public interface IRoleService {
    UserRoles getUserRoles(String userId);

    UserRoles addRoles(List<Role> roles, String userId);
}
