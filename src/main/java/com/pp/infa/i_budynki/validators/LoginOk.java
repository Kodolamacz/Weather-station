package com.pp.infa.i_budynki.validators;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 28.11.2017.
 */
public class LoginOk implements ConstraintValidator<LoginSucces,Object> {

    @Autowired
    private UserService userService;
    @Override
    public void initialize(LoginSucces constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Login login = (Login) o;
        return userService.checkUser(login) != null ? true : false;
    }
}
