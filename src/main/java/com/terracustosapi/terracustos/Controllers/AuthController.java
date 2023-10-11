package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody UserDto userDto) {
        return authService.register(userDto);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserDto userDto) {
        try {
            return authService.login(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
