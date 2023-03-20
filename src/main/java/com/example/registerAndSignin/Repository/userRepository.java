package com.example.registerAndSignin.Repository;

import com.example.registerAndSignin.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Integer>
{
    public User findByUsername(String name);
}

