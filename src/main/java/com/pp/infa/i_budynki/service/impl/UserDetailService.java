package com.pp.infa.i_budynki.service.impl;

import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blazej on 06.11.2017.
 */
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("Nie ma takiego uzytkownika :( " + s);
        }
        boolean enabled = true;
        boolean accountNotExpired = true;
        boolean credentialsNotExpired = true;
        boolean accountNotLocked = true;
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase(),
                enabled,accountNotExpired,credentialsNotExpired,accountNotLocked,getAuthorities(user.getRoles()));

    }
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
