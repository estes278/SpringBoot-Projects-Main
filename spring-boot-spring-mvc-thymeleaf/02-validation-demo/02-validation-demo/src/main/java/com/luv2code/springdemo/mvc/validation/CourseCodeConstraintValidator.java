package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{
    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode)
    {
        ConstraintValidator.super.initialize(theCourseCode);
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext)
    {
        boolean result;
        if(theCode != null)
            result = theCode.startsWith(coursePrefix);
        else return true;
        return result;
    }
}
