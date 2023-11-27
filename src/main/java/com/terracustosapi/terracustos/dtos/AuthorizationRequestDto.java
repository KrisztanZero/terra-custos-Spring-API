package com.terracustosapi.terracustos.dtos;

import com.terracustosapi.terracustos.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequestDto {
    private String sessionToken;
    private List<Role> roles;
}
