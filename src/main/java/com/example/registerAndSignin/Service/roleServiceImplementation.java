package com.example.registerAndSignin.Service;

import com.example.registerAndSignin.Model.Role;
import com.example.registerAndSignin.Repository.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="roleService")
public class roleServiceImplementation implements roleService {

    @Autowired
    private roleRepository rolerepository;
    @Override
    public Role findByName(String name) {
        Role role=rolerepository.findRoleByName(name);
        return role;
    }
}
