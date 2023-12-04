package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.LogoutResponse;
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
@RequestMapping("/api/auth")
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

    @PostMapping("/logout")
    public LogoutResponse logout(@RequestBody UserDto userDto) {
        try {
            authService.logout(userDto); // Implement the logout logic in the AuthService
            return new LogoutResponse(userDto, "Logout successful");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
