package com.example.registerAndSignin.DTO;

import com.example.registerAndSignin.Model.User;

public class userDTO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String authorities;


    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmailID(email);
        user.setPhoneNo(phone);
        user.setName(name);
        user.setAuthorities(authorities);
        return user;
    }
}
