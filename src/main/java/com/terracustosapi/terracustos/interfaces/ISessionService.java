package com.terracustosapi.terracustos.interfaces;

import com.terracustosapi.terracustos.models.Session;
import com.terracustosapi.terracustos.models.User;

public interface ISessionService {
    Session generateSession(User user);

    Session getSession(String id);
}
