package com.buyzone.user_service.entity;

import com.buyzone.user_service.enums.Gender;
import com.buyzone.user_service.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private String password;
    private String address;

    @Column(unique = true)
    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    //User can have multiple roles
    @Column(name = "roles")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable( name = "user_roles")
    private Set<Role> role=new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authoritiesList = new ArrayList<>();
        for(Role role:role){
            authoritiesList.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        }
        return authoritiesList;
    }

    @Override
    public String getUsername() {
        return email;
    }
}