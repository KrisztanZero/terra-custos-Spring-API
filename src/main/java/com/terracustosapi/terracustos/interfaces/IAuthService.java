package com.terracustosapi.terracustos.interfaces;

import com.terracustosapi.terracustos.dtos.AuthorizationRequestDto;
import com.terracustosapi.terracustos.dtos.LoginResponse;
import com.terracustosapi.terracustos.dtos.UserDto;
import com.terracustosapi.terracustos.models.User;

public interface IAuthService {
    User register(UserDto userDto);

    LoginResponse login(UserDto userDto) throws Exception;

    boolean isAuthorized(AuthorizationRequestDto request) throws Exception;
}
