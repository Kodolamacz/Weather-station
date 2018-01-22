package com.pp.infa.i_budynki.domain;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Blazej on 17.10.2017.
 */
public class Measure {

    private int id;
    private Sensor sensor;
    private double value;
    private String unit;
    private Timestamp timestamp;

    public LinkedHashMap<Double, Timestamp> getValues() {
        return values;
    }

    public void setValues(LinkedHashMap<Double, Timestamp> values) {
        this.values = values;
    }

    private LinkedHashMap<Double,Timestamp> values;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Measure(){}

    public Measure(Sensor sensor, double value, String unit, Timestamp timestamp)
    {
        this.sensor = sensor;
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
    }
}
