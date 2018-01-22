package com.pp.infa.i_budynki.validators;

import com.pp.infa.i_budynki.domain.User;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Blazej on 14.11.2017.
 */
@Component
public class PasswordValidator implements ConstraintValidator<PasswordMatches,Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) object;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
