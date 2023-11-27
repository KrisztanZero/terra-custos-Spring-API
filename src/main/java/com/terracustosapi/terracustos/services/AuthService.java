package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.dtos.AuthorizationRequestDto;
import com.terracustosapi.terracustos.dtos.LoginResponse;
import com.terracustosapi.terracustos.dtos.UserDto;
import com.terracustosapi.terracustos.enums.Role;
import com.terracustosapi.terracustos.interfaces.IAuthService;
import com.terracustosapi.terracustos.interfaces.IRoleService;
import com.terracustosapi.terracustos.interfaces.ISessionService;
import com.terracustosapi.terracustos.interfaces.IUserService;
import com.terracustosapi.terracustos.models.Session;
import com.terracustosapi.terracustos.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserService userService;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private IRoleService roleService;

    @Override
    public User register(UserDto userDto) {

        User authUser = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword()).build();

        User appUser = userService.save(authUser);
        roleService.addRoles(List.of(Role.STANDARD), appUser.getUserId());
        return appUser;
    }

    @Override
    public LoginResponse login(UserDto userDto) throws Exception {
        User user = null;
        if (checkCredential(userDto.getEmail())) {
            user = userService.getUserByEmail(userDto.getEmail());
        } else if (checkCredential(userDto.getUsername())) {
            user = userService.getUserByName(userDto.getUsername());
        }
        if (user == null) {
            throw new Exception("Invalid username or email");
        }
        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new Exception("Wrong password");
        }
        Session session = sessionService.generateSession(user);

        return new LoginResponse(new UserDto((user)), session.getSessionId());
    }

    @Override
    public boolean isAuthorized(AuthorizationRequestDto request) {
        Session session;
        session = sessionService.getSession(request.getSessionToken());
        User user = userService.getUserById(session.getUserId());
        List<Role> userRoles = roleService.getUserRoles(user.getUserId()).getRoles();

        return request.getRoles().stream().anyMatch(userRoles::contains);
    }

    private boolean checkCredential(String credential) {
        return (credential != null && !credential.isEmpty());
    }
}
