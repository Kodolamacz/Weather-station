package com.pp.infa.i_budynki.service.impl;

import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.domain.repo.SensorDao;
import com.pp.infa.i_budynki.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Blazej on 22.11.2017.
 */
@Service
public class SensorServiceImpl implements SensorService {

    @Qualifier("getSensorDao")
    @Autowired
    private SensorDao sensorDao;

    @Override
    public List<Sensor> getSensors(User user) {
        return sensorDao.getSensors(user);
    }

    @Override
    public void addSensor(String name, String owner) {
        sensorDao.addSensor(name,owner);
    }

    @Override
    public Sensor getSensorByName(String name) {
        return sensorDao.getSensorByName(name);
    }

    @Override
    public Sensor getSensorById(int id) {
        return sensorDao.getSensorById(id);
    }
}
