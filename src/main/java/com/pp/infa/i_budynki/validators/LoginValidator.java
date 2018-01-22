package com.pp.infa.i_budynki.validators;

import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.domain.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 20.11.2017.
 */
@Component
public class LoginValidator implements ConstraintValidator<UserExists,Object> {

    @Qualifier("getUserDao")
    @Autowired
    private UserDao userDao;

    @Override
    public void initialize(UserExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) o;
        return userDao.getLogins().contains(user.getLogin()) ? false : true;
    }
}
