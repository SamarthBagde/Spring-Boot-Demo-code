package com.example.SpringSecurityDemo.service;

import com.example.SpringSecurityDemo.entity.Role;
import com.example.SpringSecurityDemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
}
