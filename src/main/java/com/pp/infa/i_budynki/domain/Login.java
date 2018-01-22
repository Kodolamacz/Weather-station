package com.pp.infa.i_budynki.domain;

import com.pp.infa.i_budynki.validators.LoginSucces;

/**
 * Created by Blazej on 01.11.2017.
 */
@LoginSucces
public class Login {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public Login(String login){
        this.login = login;
    }
    public Login(){}
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
