package com.pp.infa.i_budynki.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Blazej on 28.11.2017.
 */
@Target({FIELD,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = SensorValidator.class)
@Documented
public @interface SensorExists {
    String message() default "Czujnik już istnieje";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
