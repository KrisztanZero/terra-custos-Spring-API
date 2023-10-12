package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;

import java.util.List;

public interface IUserService {
    User getUserBySession(String session);
    User getUserByName(String username);
    User getUserByEmail(String email);
    User getUserById(String id);
    List<User> getALl();
    User save(User authUser);
}
