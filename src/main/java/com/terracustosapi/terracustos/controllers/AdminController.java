package com.terracustosapi.terracustos.controllers;

import com.terracustosapi.terracustos.dtos.UserDto;
import com.terracustosapi.terracustos.interfaces.IAdminService;
import com.terracustosapi.terracustos.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;
    @GetMapping("/get-all-user")
    public List<UserDto> getAllUser(){
        return adminService.getALl().stream().map(UserDto::new).collect(Collectors.toList());
    }
}
