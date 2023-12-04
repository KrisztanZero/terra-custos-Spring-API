package com.terracustosapi.terracustos.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResponse {
    private UserDto user;
    private String message;
}
