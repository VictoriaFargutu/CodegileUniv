package com.codegile.university.victoria.week1.day4.problem3;

import java.sql.Date;
import java.util.List;

public class Benefit {
    private int id;
    private String name;
    private Date date;

    public Benefit(String name, Date date){
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "; date: " + this.date;
    }
}
