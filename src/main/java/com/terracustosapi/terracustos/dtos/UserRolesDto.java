package com.terracustosapi.terracustos.dtos;

import com.terracustosapi.terracustos.enums.Role;
import com.terracustosapi.terracustos.models.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRolesDto {
    private List<Role> roles;

    public UserRolesDto(UserRoles userRoles) {
        this.roles = userRoles.getRoles();
    }
}
