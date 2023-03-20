package com.example.registerAndSignin.Repository;

import com.example.registerAndSignin.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<Role,Integer>
{
}
