package com.terracustosapi.terracustos.Interfaces;

import com.terracustosapi.terracustos.Models.Session;
import com.terracustosapi.terracustos.Models.User;

import java.util.List;

public interface ISessionService {
    Session generateSession(User user);

    Session getSession(String id);
    List<Session> getSessionsByUser(String id);
    void deleteSessions(List<Session> sessions);
}
