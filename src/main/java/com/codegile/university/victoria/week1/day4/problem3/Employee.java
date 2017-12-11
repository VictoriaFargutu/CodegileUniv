package com.codegile.university.victoria.week1.day4.problem3;

import java.sql.Date;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birhtday;
    private List benefits;

    public Employee(String name, String lastName, String ssn, Date birthday, Benefit benefit){
        this.firstName = name;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birhtday = birthday;
        this.benefits.add(benefit);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirhtday() {
        return birhtday;
    }

    public void setBirhtday(Date birhtday) {
        this.birhtday = birhtday;
    }

    public List getBenefits() {
        return benefits;
    }

    public void setBenefits(List benefits) {
        this.benefits = benefits;
    }
}
