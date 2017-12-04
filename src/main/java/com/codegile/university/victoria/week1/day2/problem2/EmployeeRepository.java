package com.codegile.university.victoria.week1.day2.problem2;

import java.sql.Date;
import java.util.List;

public interface EmployeeRepository {

    public void createEmployee(String firstName, String lastName, String cnp, Date birthday);

    public void readEmployeesBornAfterEighties();

    public List<Employee> readEmployeesBornYearDescending();

    public void updateEmployeeData(int id, String employeeLasName);

    public void deleteEmployee(int id);
}
