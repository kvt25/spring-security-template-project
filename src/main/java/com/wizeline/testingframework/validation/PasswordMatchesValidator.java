package com.wizeline.testingframework.validation;

import com.wizeline.testingframework.validation.annotation.PasswordMatches;
import com.wizeline.testingframework.web.data.UserData;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserData user = (UserData) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }

}
