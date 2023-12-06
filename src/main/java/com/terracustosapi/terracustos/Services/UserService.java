package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.IRepositories.IUserRepository;
import com.terracustosapi.terracustos.Interfaces.IRoleService;
import com.terracustosapi.terracustos.Interfaces.ISessionService;
import com.terracustosapi.terracustos.Interfaces.IUserService;
import com.terracustosapi.terracustos.Models.Session;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Models.UserRoles;
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

    @Override
    public User updateUser(String sessionId, UserDto updatedUserDto){
        User user = getUserBySession(sessionId);

        user.setUsername(updatedUserDto.getUsername());
        user.setEmail(updatedUserDto.getEmail());
        user.setIntroduction(updatedUserDto.getIntroduction());

        return userRepository.save(user);
    }

    @Override
    public boolean isUsernameOrEmailAlreadyRegistered(String username, String email) {
        boolean usernameExists = userRepository.findByUsername(username).isPresent();
        boolean emailExists = userRepository.findByEmail(email).isPresent();
        return usernameExists || emailExists;
    }
}
