package com.pp.infa.i_budynki.domain.repo;

import com.pp.infa.i_budynki.domain.Sensor;

import java.util.Date;
import java.util.Map;

/**
 * Created by Blazej on 22.11.2017.
 */
public interface MeasureDao {

    Map<Object, Object> getSensorData(Sensor sensor);
    Map<Object, Object> getSensorData(Sensor sensor, String begin, String end, Double min, Double max);
}
