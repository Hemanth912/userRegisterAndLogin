package com.example.registerAndSignin.Service;

import com.example.registerAndSignin.DTO.userDTO;
import com.example.registerAndSignin.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {
    User save(userDTO user);
    List<User> findAll();
    User findOne(String username);
}
