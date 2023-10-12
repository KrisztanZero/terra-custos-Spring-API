package com.terracustosapi.terracustos.Dtos;

import com.terracustosapi.terracustos.Models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String email;
    private String password;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
