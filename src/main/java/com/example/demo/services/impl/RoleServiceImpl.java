package com.example.demo.services.impl;

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<Role> all() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) throws Exception {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty()) {
            throw new Exception("Role Not Found");
        }

        return role.get();
    }

    @Override
    public Role save(Role object) {
        return roleRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
