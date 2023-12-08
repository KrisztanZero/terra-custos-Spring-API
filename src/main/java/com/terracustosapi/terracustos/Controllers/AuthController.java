package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.LoginResponse;
import com.terracustosapi.terracustos.Dtos.LogoutResponse;
import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Services.AuthService;
import com.terracustosapi.terracustos.utils.TokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public LogoutResponse logout(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String sessionId = TokenExtractor.extractSessionId(authorizationHeader);
            return authService.logout(sessionId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/check-username-email")
    public ResponseEntity<String> checkUsernameOrEmail(@RequestParam String username, @RequestParam String email) {
        boolean isAlreadyRegistered = authService.isUsernameOrEmailAlreadyRegistered(username, email);
        if (isAlreadyRegistered) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username or email already registered");
        } else {
            return ResponseEntity.ok("Username and email are available");
        }
    }
}
