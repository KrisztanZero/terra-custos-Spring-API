package com.terracustosapi.terracustos.interfaces;

public interface IGreetingService {
    String getWelcomeMessage();
    String getUserWelcomeMessage(String sessionId);
    String getPremiumMessage(String sessionId);
}
