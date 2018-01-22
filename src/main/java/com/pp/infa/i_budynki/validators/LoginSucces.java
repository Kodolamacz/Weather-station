package com.pp.infa.i_budynki.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Blazej on 28.11.2017.
 */
@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = LoginOk.class)
@Documented
public @interface LoginSucces {
    String message() default "Nieprawidłowy login lub hasło";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
