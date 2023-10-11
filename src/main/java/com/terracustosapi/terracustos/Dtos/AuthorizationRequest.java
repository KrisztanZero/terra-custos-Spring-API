package com.terracustosapi.terracustos.Dtos;

import com.terracustosapi.terracustos.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    private String sessionToken;
    private List<Role> roles;
}
