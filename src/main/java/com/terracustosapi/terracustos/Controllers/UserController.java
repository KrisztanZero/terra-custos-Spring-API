package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Dtos.UserRolesDto;
import com.terracustosapi.terracustos.Interfaces.IUserService;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.utils.TokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/get-by-session")
    public UserDto getBySession(@RequestHeader("Authorization") String authorizationHeader){
        String sessionId = TokenExtractor.extractSessionId(authorizationHeader);
        return new UserDto(userService.getUserBySession(sessionId));
    }

    @GetMapping("/get-by-id/{id}")
    public UserDto getUserById(@PathVariable String id){
        return new UserDto(userService.getUserById(id));
    }

    @GetMapping("/get-user-roles")
    public UserRolesDto getRoles(@RequestHeader("Authorization") String authorizationHeader) {
        String sessionId = TokenExtractor.extractSessionId(authorizationHeader);
        return new UserRolesDto(userService.getUserRoles(sessionId));
    }

    @PutMapping("/update-introduction")
    public UserDto updateIntroduction(@RequestHeader("Authorization") String authorizationHeader,
                                      @RequestBody String introduction) {
        String sessionId = TokenExtractor.extractSessionId(authorizationHeader);
        User updatedUser = userService.updateIntroduction(sessionId, introduction);
        return new UserDto(updatedUser);
    }

    @PutMapping("/update-user")
    public UserDto updateUser(@RequestHeader("Authorization") String authorizationHeader,
                              @RequestBody UserDto updatedUserDto) {
            String sessionId = TokenExtractor.extractSessionId(authorizationHeader);

            User updatedUser = userService.updateUser(sessionId, updatedUserDto);
            return new UserDto(updatedUser);
    }
}
