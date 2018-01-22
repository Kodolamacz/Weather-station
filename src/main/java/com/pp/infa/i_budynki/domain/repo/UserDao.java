package com.pp.infa.i_budynki.domain.repo;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.User;

import java.util.List;

/**
 * Created by Blazej on 20.10.2017.
 */
public interface UserDao {

    boolean register(User user);
    User checkUser(Login login);
    User findUserByName(String username);
    List<String> getLogins();
    User findUserById(int id);

}
