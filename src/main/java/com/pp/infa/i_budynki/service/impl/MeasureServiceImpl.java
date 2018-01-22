package com.pp.infa.i_budynki.service.impl;

import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.repo.MeasureDao;
import com.pp.infa.i_budynki.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by Blazej on 22.11.2017.
 */
@Service
public class MeasureServiceImpl implements MeasureService {

    @Qualifier("getMeasureDao")
    @Autowired
    private MeasureDao measureDao;

    @Override
    public Map<Object, Object> getSensorData(Sensor sensor) {
        return measureDao.getSensorData(sensor);
    }

    public Map<Object, Object> getSensorData(Sensor sensor, String begin, String end, Double min, Double max){
        return measureDao.getSensorData(sensor,begin,end,min,max);
    }

}
