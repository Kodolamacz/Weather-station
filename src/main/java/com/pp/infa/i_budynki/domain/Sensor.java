package com.pp.infa.i_budynki.domain;

import com.pp.infa.i_budynki.validators.SensorExists;
import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Blazej on 17.10.2017.
 */
public class Sensor {

    private int id;

    @SensorExists
    @NotEmpty(message = "Nazwa nie może być pusta")
    @NotNull
    private String name;

    //@NotBlank(message = "Nazwa użytkownika nie może być pusta")
    @NotEmpty(message = "Nazwa użytkownika nie może być pusta")
    private  String owner;

    public Sensor(){}

    public Sensor(String name, String user){

        this.name = name;
        this.owner = user;

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

    public String  getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
