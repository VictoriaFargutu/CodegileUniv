package com.codegile.university.victoria.week1.day2.problem2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private String cnp;
    private Date birthday;

    public Employee(String firstName, String lastName, String cnp, Date birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthday = birthday;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getCnp(){
        return this.cnp;
    }

    public void setCnp(String cnp){
        this.cnp = cnp;
    }

    public Date getBirthday(){
        return this.birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public String toString(){
        return "First name: " + firstName + "; Last name: " + lastName +"; ssn: " + cnp + "; birthday: " + birthday + ".";
    }

    @Override
    public int compareTo(Employee employee) {
        return this.birthday.getYear() - employee.getBirthday().getYear();
    }
}
