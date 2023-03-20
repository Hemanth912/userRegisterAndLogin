package com.example.registerAndSignin.Service;

import com.example.registerAndSignin.Model.Role;
import org.springframework.stereotype.Service;

@Service
public interface roleService {
    Role findByName(String name);
}
