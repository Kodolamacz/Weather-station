package com.pp.infa.i_budynki.controllers;

import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.service.MeasureService;
import com.pp.infa.i_budynki.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Blazej on 02.01.2018.
 */
@Controller
//@RequestMapping("/stacja")
public class RestChartController {

    @Autowired
    private MeasureService measureService;

    @Autowired
    private SensorService sensorService;
//List<Measure>
    @RequestMapping(value = "/chart/data/{sensor}",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<Object, Object> createDataJSON(@PathVariable("sensor") String sensorId){

        int id = Integer.parseInt(sensorId);
        Sensor sensor = sensorService.getSensorById(id);
       System.out.println("JSON?  " +  measureService.getSensorData(sensor));
        return measureService.getSensorData(sensor);
    }

    @RequestMapping(value = "/chart/data/{sensor}/{beginDate}/{endDate}/{minValue}/{maxValue}",
            method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<Object, Object> createFilteredDataJSON(@PathVariable("sensor") String sensorId,
           @PathVariable("beginDate") String beginDate, @PathVariable("endDate") String endDate,
           @PathVariable("minValue") String min, @PathVariable("maxValue") String max) throws ParseException {


        int id = Integer.parseInt(sensorId);
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        //String begin = df.parse(beginDate);
        //String end = df.parse(endDate);
        double minVal = Double.parseDouble(min);
        double maxVal = Double.parseDouble(max);
        Sensor sensor = sensorService.getSensorById(id);
        System.out.println("TEST " +beginDate + " "+ endDate + " "+minVal + " " + maxVal);

        return measureService.getSensorData(sensor,beginDate,endDate,minVal,maxVal);
    }
    
}
