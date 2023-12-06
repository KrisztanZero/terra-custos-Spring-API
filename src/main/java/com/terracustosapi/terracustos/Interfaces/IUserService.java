package com.terracustosapi.terracustos.Interfaces;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Models.UserRoles;

public interface IUserService {
    User getUserBySession(String session);
    User getUserByName(String username);
    User getUserByEmail(String email);
    User getUserById(String id);
    User save(User authUser);
    UserRoles getUserRoles(String sessionId);
    User updateIntroduction(String sessionId, String newIntroduction);
    User updateUser(String sessionId, UserDto updatedUserDto);
    boolean isUsernameOrEmailAlreadyRegistered(String username, String email);
}
