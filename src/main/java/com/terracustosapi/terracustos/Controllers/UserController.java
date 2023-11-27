package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Dtos.UserRolesDto;
import com.terracustosapi.terracustos.Models.User;
import com.terracustosapi.terracustos.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/get-by-session/{sessionId}")
    public UserDto getBySession(@PathVariable String sessionId){
        return new UserDto(userService.getUserBySession(sessionId));
    }

    @GetMapping("/get-by-id/{id}")
    public UserDto getUserById(@PathVariable String id){
        return new UserDto(userService.getUserById(id));
    }

    @GetMapping("/get-user-roles/{sessionId}")
    public UserRolesDto getRoles(@PathVariable String sessionId){
        return new UserRolesDto(userService.getUserRoles(sessionId));
    }

    @PutMapping("/update-introduction/{sessionId}")
    public UserDto updateIntroduction(
            @PathVariable String sessionId,
            @RequestBody String introduction
    ) {
        User updatedUser = userService.updateIntroduction(sessionId, introduction);

        return new UserDto(updatedUser);
    }
}
