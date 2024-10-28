package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer
{
    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    @Min(value=0, message=" Must be greater than or equal to zero")
    @Max(value = 10, message=" No more than 10 passes can be used at a time")
    @NotNull(message=" is required")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message=" Only 5 chars/digits")
    private String zipCode;

    @CourseCode(value = "DEVS", message="must start with DEVS")
    private String courseCode;

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = " Only 5 chars/digits") String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}",
            message = " Only 5 chars/digits") String zipCode)
    {
        this.zipCode = zipCode;
    }

    @Min(value = 0, message = " Must be greater than or equal to zero")
    @Max(value = 10, message = " No more than 10 passes can be used at a time")
    public Integer getFreePasses()
    {
        return freePasses;
    }

    public void setFreePasses(@Min(value = 0, message = " Must be greater than or equal to zero") @Max(value = 10, message = " No more than 10 passes can be used at a time") Integer freePasses)
    {
        this.freePasses = freePasses;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
