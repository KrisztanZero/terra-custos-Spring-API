package com.terracustosapi.terracustos.Controllers;

import com.terracustosapi.terracustos.Dtos.UserDto;
import com.terracustosapi.terracustos.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/getBySession/{sessionId}")
    public UserDto getBySession(@PathVariable String sessionId){
        return new UserDto(userService.getUserBySession(sessionId));
    }

    @GetMapping("/getById/{id}")
    public UserDto getUserById(@PathVariable String id){
        return new UserDto(userService.getUserById(id));
    }

    @GetMapping("/getAll")
    public List<UserDto> getAll(){
        return userService.getALl().stream().map(UserDto::new).collect(Collectors.toList());
    }
}
