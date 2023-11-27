package com.terracustosapi.terracustos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session {
    @Id
    private String sessionId;
    private String userId;
}
