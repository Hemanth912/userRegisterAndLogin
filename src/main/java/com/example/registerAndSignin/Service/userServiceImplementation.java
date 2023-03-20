package com.example.registerAndSignin.Service;

import com.example.registerAndSignin.DTO.userDTO;
import com.example.registerAndSignin.Model.Role;
import com.example.registerAndSignin.Model.User;
import com.example.registerAndSignin.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value="userService")

public class userServiceImplementation implements userService{
    @Autowired
    private roleService roleservice;

    @Autowired
    private userRepository userrepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user)
    {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role-> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()))
        });
        return authorities;
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User save(userDTO user) {
        User nUser = user.getUserFromDto();
        nUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        Role role = roleservice.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if (nUser.getEmail().split("@")[1].equals("admin.edu")) {
            role = roleservice.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userrepository.save(nUser);
    }
}
