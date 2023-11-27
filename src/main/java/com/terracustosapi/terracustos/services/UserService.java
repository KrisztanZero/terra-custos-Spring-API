package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.iRepositories.IUserRepository;
import com.terracustosapi.terracustos.interfaces.IRoleService;
import com.terracustosapi.terracustos.interfaces.ISessionService;
import com.terracustosapi.terracustos.interfaces.IUserService;
import com.terracustosapi.terracustos.models.Session;
import com.terracustosapi.terracustos.models.User;
import com.terracustosapi.terracustos.models.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getUserBySession(String sessionId) {
        Session session = sessionService.getSession(sessionId);
        return userRepository.findById(session.getUserId()).orElseThrow();
    }

    @Override
    public User getUserByName(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User save(User authUser) {
        return userRepository.save(authUser);
    }

    @Override
    public UserRoles getUserRoles(String sessionId) {
        Session session = sessionService.getSession(sessionId);
        return roleService.getUserRoles(session.getUserId());
    }

    @Override
    public User updateIntroduction(String sessionId, String introduction) {
        User user = getUserBySession(sessionId);
            user.setIntroduction(introduction);
            return userRepository.save(user);
    }
}
