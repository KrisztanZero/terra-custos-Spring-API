package com.terracustosapi.terracustos.services;

import com.terracustosapi.terracustos.iRepositories.IUserRepository;
import com.terracustosapi.terracustos.interfaces.IAdminService;
import com.terracustosapi.terracustos.interfaces.IRoleService;
import com.terracustosapi.terracustos.interfaces.ISessionService;
import com.terracustosapi.terracustos.models.User;
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
