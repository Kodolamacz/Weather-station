package com.pp.infa.i_budynki.domain;

import com.pp.infa.i_budynki.validators.PasswordMatches;
import com.pp.infa.i_budynki.validators.UserExists;
import com.pp.infa.i_budynki.validators.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Blazej on 17.10.2017.
 */
@UserExists
@PasswordMatches(message = "Hasła są niezgodne")
public class User {

    private int id;


    @NotNull(message ="Pole nie może być puste")
    private String name;

    //@NotEmpty
    @Size(min = 6, max = 32,message = "Hasło musi mieć od 6 - 32 znaków")
    @NotNull(message ="Pole nie może być puste")
    private  String password;
    private  String matchingPassword;

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    //@NotEmpty
    @NotNull(message ="Pole nie może być puste")
    private String login;

    //@NotEmpty
    @NotNull(message ="Pole nie może być puste")
    private String surname;

    @ValidEmail
    @NotNull(message ="Pole nie może być puste")
    private String email;

    private List<Sensor> sensorsList;

    public List<Sensor> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(List<Sensor> sensorsList) {
        this.sensorsList = sensorsList;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    private List<String> roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
