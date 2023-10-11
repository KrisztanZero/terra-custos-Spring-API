package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Dtos.AuthorizationRequest;
import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;

public interface IAuthService {
    User register(UserDto userDto);

    LoginResponse login(UserDto userDto) throws Exception;

    boolean isAuthorized(AuthorizationRequest request) throws Exception;
}
