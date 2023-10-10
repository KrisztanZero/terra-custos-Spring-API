package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.IRepositories.IUserRepository;
import com.terracustosapi.terracustos.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private IUserRepository userRepository;

    public User register(UserDto userDto) {

        User authUser = User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .password(userDto.getPassword()).build();

        return userRepository.save(authUser);
    }

    public User login(UserDto userDto) throws Exception {
        User user = !userDto.getEmail().isEmpty() ? userRepository.findByEmail(userDto.getEmail()) : userRepository.findByUserName(userDto.getUserName());
        if (!user.getPassword().equals(userDto.getPassword())) {
            throw new Exception("Wrong password");
        }
        return user;
    }
}
