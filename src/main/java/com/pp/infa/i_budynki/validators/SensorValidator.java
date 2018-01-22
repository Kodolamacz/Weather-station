package com.pp.infa.i_budynki.validators;

import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 28.11.2017.
 */
public class SensorValidator implements ConstraintValidator<SensorExists,String> {

    @Autowired
    private SensorService sensorService;

    @Override
    public void initialize(SensorExists constraintAnnotation) {

    }

//    @Override
//    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
//        Sensor s = (Sensor) o;
//
//        return sensorService.getSensorByName(s.getName()) != null ? false : true;
//    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return sensorService.getSensorByName(s) != null ? false : true;
    }

}
