package com.luv2code.springboot.thymeleafdemo.model;

import java.util.List;

public class Student
{
    private String firstName;
    private String lastName;
    private String country;
    private String team;
    private List<String> movieGenres;

    public Student() {}

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

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public List<String> getMovieGenres()
    {
        return movieGenres;
    }

    public void setMovieGenres(List<String> movieGenres)
    {
        this.movieGenres = movieGenres;
    }
}
