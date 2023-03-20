package com.example.registerAndSignin.Model;

import jakarta.persistence.*;

@Entity

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
}
