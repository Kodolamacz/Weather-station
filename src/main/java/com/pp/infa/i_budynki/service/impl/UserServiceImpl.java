package com.pp.infa.i_budynki.service.impl;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.domain.repo.UserDao;
import com.pp.infa.i_budynki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Blazej on 20.10.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Qualifier("getUserDao")
    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public User checkUser(Login login) {
        return userDao.checkUser(login);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }


}
