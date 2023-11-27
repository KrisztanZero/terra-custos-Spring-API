package com.terracustosapi.terracustos.models;

import com.terracustosapi.terracustos.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("userRoles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoles {
    @Id
    private String userId;
    private List<Role> roles;
}
