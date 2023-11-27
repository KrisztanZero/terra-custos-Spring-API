package com.terracustosapi.terracustos.Interfaces;

public interface IGreetingService {
    String getWelcomeMessage();
    String getUserWelcomeMessage(String sessionId);
    String getPremiumMessage(String sessionId);
}
