package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.IRepositories.IUserRepository;
import com.terracustosapi.terracustos.Models.Session;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Models.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getALl() {
        return userRepository.findAll();

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
}
