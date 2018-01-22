package com.pp.infa.i_budynki.service;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.User;

/**
 * Created by Blazej on 20.10.2017.
 */
public interface UserService  {

    boolean register(User user);
    User checkUser(Login login);
    User findUserByUsername(String username);
    User findUserById(int id);

}
