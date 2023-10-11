package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Models.Session;
import com.terracustosapi.terracustos.Models.User;

public interface ISessionService {
    Session generateSession(User user);

    Session getSession(String id);
}
