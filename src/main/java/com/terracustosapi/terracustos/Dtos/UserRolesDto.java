package com.terracustosapi.terracustos.Dtos;

import com.terracustosapi.terracustos.Enums.Role;
import com.terracustosapi.terracustos.Models.UserRoles;
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
