package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.AuthorizationRequestDto;
import com.terracustosapi.terracustos.Enums.Role;
import com.terracustosapi.terracustos.Services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/Greeting")
public class GreetingController {
    @Autowired
    private IAuthService authService;
    @GetMapping()
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/user-welcome/{sessionId}")
    public String userWelcome(@PathVariable String sessionId){
        List<Role> allowedRoles = List.of(Role.STANDARD, Role.PREMIUM);
        AuthorizationRequestDto request = new AuthorizationRequestDto(sessionId, allowedRoles);
        try {
            if(authService.isAuthorized(request)){
                return "You are Standard.";
            } else {
                return "Unauthorized!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/premium-message/{sessionId}")
    public String premiumMessage(@PathVariable String sessionId){
        List<Role> allowedRoles = List.of(Role.PREMIUM);
        AuthorizationRequestDto request = new AuthorizationRequestDto(sessionId, allowedRoles);
        try {
            if(authService.isAuthorized(request)){
                return "You are Premium.";
            } else {
                return "Unauthorized!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
