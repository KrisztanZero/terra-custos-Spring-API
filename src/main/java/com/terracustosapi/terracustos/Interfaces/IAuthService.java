package com.terracustosapi.terracustos.Interfaces;

import com.terracustosapi.terracustos.Dtos.AuthorizationRequestDto;
import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.LogoutResponse;
import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;

public interface IAuthService {
    User register(UserDto userDto);

    LoginResponse login(UserDto userDto) throws Exception;
    LogoutResponse logout(String sessionId) throws Exception;

    boolean isAuthorized(AuthorizationRequestDto request) throws Exception;
    boolean isUsernameOrEmailAlreadyRegistered(String username, String email);
}
