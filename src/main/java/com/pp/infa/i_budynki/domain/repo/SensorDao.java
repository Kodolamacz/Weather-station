package com.pp.infa.i_budynki.domain.repo;

import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.User;

import java.util.List;

/**
 * Created by Blazej on 22.11.2017.
 */
public interface SensorDao {

    List<Sensor> getSensors(User user);
    void addSensor(String name, String owner);
    Sensor getSensorByName(String name);
    Sensor getSensorById(int id);
}
