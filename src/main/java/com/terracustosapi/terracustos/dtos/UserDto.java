package com.terracustosapi.terracustos.dtos;

import com.terracustosapi.terracustos.models.User;
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
    private String introduction;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.introduction = user.getIntroduction();
    }
}
