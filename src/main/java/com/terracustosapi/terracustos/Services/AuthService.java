package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Dtos.AuthorizationRequest;
import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Enums.Role;
import com.terracustosapi.terracustos.IRepositories.IUserRepository;
import com.terracustosapi.terracustos.Models.Session;
import com.terracustosapi.terracustos.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private IRoleService roleService;

    @Override
    public User register(UserDto userDto) {

        User authUser = User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .password(userDto.getPassword()).build();

        User appUser = userRepository.save(authUser);
        roleService.addRoles(List.of(Role.STANDARD), appUser.getId());
        return appUser;
    }

    @Override
    public LoginResponse login(UserDto userDto) throws Exception {
        User user = null;
        if(checkCredential(userDto.getEmail())){
            user = userRepository.findByEmail(userDto.getEmail());
        } else if(checkCredential(userDto.getUserName())){
            user = userRepository.findByUserName(userDto.getUserName());
        }
        if (user == null){
            throw new Exception("Invalid username or email");
        }
        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new Exception("Wrong password");
        }
        Session session = sessionService.generateSession(user);

        return new LoginResponse(user, session.getSessionId());
    }
    @Override
    public boolean isAuthorized(AuthorizationRequest request) throws Exception {
        Session session = null;
        try{
            session = sessionService.getSession(request.getSessionToken());
        }catch(Exception e){
            throw new Exception("Invalid session");
        };
        if(session == null) {
            throw new Exception("Invalid session");
        }
        User user = userRepository.findById(session.getUserId()).orElseThrow();
        List<Role> userRoles = roleService.getUserRoles(user.getId()).getRoles();

        return request.getRoles().stream().anyMatch(userRoles::contains);
    }

    private boolean checkCredential(String credential){
        return (credential != null && !credential.isEmpty());
    }
}
