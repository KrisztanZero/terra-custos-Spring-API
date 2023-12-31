package com.terracustosapi.terracustos.Dtos;

import com.terracustosapi.terracustos.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private UserDto user;
    private String sessionToken;
}
