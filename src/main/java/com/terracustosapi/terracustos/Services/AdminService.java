package com.terracustosapi.terracustos.Services;

import com.terracustosapi.terracustos.IRepositories.IUserRepository;
import com.terracustosapi.terracustos.Interfaces.IAdminService;
import com.terracustosapi.terracustos.Interfaces.IRoleService;
import com.terracustosapi.terracustos.Interfaces.ISessionService;
import com.terracustosapi.terracustos.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private ISessionService sessionService;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getALl() {
        return userRepository.findAll();

    }
}
