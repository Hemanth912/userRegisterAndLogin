package com.example.registerAndSignin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//public class User implements UserDetails{
public class User{
    //public static final String delimiter = ":";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String Username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String emailID;

    @Column
    private String phoneNo;

    @Column
    private String name;

    @Column
    private String authorities;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLES",
            joinColumns = {@JoinColumn(name="USER_ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID")})
    private Set<Role> roles;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String[] authorities = this.authorities.split(delimiter);
//        return Arrays.stream(authorities).
//                map(x -> new SimpleGrantedAuthority(x)).
//                collect(Collectors.toList());
//    }




   /* @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }*/
}
