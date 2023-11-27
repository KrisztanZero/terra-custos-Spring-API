package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.iRepositories.ISessionRepository;
import com.terracustosapi.terracustos.interfaces.ISessionService;
import com.terracustosapi.terracustos.models.Session;
import com.terracustosapi.terracustos.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private ISessionRepository sessionRepository;

    @Override
    public Session generateSession(User user) {
        Session session = new Session(generateToken(), user.getUserId());
        sessionRepository.save(session);
        return session;
    }

    @Override
    public Session getSession(String id) {
        return sessionRepository.findById(id).orElseThrow();
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
