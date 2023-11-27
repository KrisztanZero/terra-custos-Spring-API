package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.dtos.AuthorizationRequestDto;
import com.terracustosapi.terracustos.enums.Role;
import com.terracustosapi.terracustos.interfaces.IAuthService;
import com.terracustosapi.terracustos.interfaces.IGreetingService;
import com.terracustosapi.terracustos.interfaces.IRoleService;
import com.terracustosapi.terracustos.interfaces.ISessionService;
import com.terracustosapi.terracustos.interfaces.IUserService;
import com.terracustosapi.terracustos.models.Session;
import com.terracustosapi.terracustos.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GreetingService implements IGreetingService {

    @Autowired
    private IAuthService authService;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public String getWelcomeMessage(){
        return "Welcome";
    }
    @Override
    public String getUserWelcomeMessage(String sessionId) {
        List<Role> allowedRoles = List.of(Role.STANDARD, Role.PREMIUM, Role.ADMIN);
        AuthorizationRequestDto request = new AuthorizationRequestDto(sessionId, allowedRoles);
        try {
            if(authService.isAuthorized(request)){
                Role highestRole = getHighestRole(sessionId);
                return "Your highest role is: " + highestRole.toString();
            } else {
                return "Unauthorized!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPremiumMessage(String sessionId) {
        List<Role> allowedRoles = List.of(Role.PREMIUM);
        AuthorizationRequestDto request = new AuthorizationRequestDto(sessionId, allowedRoles);
        try {
            if(authService.isAuthorized(request)){
                return "You have premium role to read this message.";
            } else {
                return "Unauthorized!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private Role getHighestRole(String sessionId) {
        AuthorizationRequestDto request = new AuthorizationRequestDto(sessionId, Collections.emptyList());
        Session session = sessionService.getSession(request.getSessionToken());
        User user = userService.getUserById(session.getUserId());
        List<Role> userRoles = roleService.getUserRoles(user.getUserId()).getRoles();

        if (!userRoles.isEmpty()) {
            return userRoles.get(userRoles.size() - 1);
        } else {
            return Role.STANDARD;
        }
    }
}
