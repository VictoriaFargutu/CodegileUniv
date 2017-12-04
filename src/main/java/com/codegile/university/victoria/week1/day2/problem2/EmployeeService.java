package com.codegile.university.victoria.week1.day2.problem2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private static Scanner input = new Scanner(System.in);
    public static int CREATE_OPTION = 1;
    public static int READ_BORN_AFTER_EIGHTIES_OPTION = 2;
    public static int READ_BORN_YEAR_DESCENDING_OPTION = 3;
    public static int UPDATE_OPTION = 4;
    public static int DELETE_OPTION = 5;

    private static SqlEmployeeRepository sqlEmployeeRepository = null;

    public static void main(String[] args){
        showMenu();
    }

    public static void showMenu(){
        System.out.println("Choose one option from the menu below: ");
        System.out.println("1.Create");
        System.out.println("2.Read employees born after Eighties");
        System.out.println("3.Read employees by born year descending");
        System.out.println("4.Update");
        System.out.println("5.Delete");
        int option = input.nextInt();

        sqlEmployeeRepository = new SqlEmployeeRepository();

        if(option == CREATE_OPTION){
            createEmployee();

        }else if(option == READ_BORN_AFTER_EIGHTIES_OPTION) {
            sqlEmployeeRepository.readEmployeesBornAfterEighties();

        }else if(option == READ_BORN_YEAR_DESCENDING_OPTION) {
            List<Employee> employeesBornYearDescending = sqlEmployeeRepository.readEmployeesBornYearDescending();
            Collections.sort(employeesBornYearDescending, Collections.reverseOrder());

        }else if(option == UPDATE_OPTION){
            updateEmployee();

        }else if(option == DELETE_OPTION){
            System.out.println("Introduce the employee's id: ");
            int id = input.nextInt();
            sqlEmployeeRepository.deleteEmployee(id);
            System.out.println("The employee was removed from the table!");

        } else{
            showMenu();
        }
    }

    public static void createEmployee(){
        System.out.println("Introduce the employee's first name: ");
        String firstName = input.next();
        System.out.println("Introduce the employee's last name: ");
        String lastName = input.next();
        System.out.println("Introduce the employee's ssn: ");
        String ssn = input.next();
        System.out.println("Introduce the employee's date of birthday(yy-mm-dd): ");
        String birthday = input.next();
        DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        Date birthDate = null;
        try {
            birthDate = formatter.parse(birthday);
            System.out.println(birthDate);
            java.sql.Date date = new java.sql.Date(birthDate.getTime());

            sqlEmployeeRepository.createEmployee(firstName, lastName, ssn, date);

            System.out.println("The data was inserted successfully!");

        } catch (ParseException e) {
            System.out.println("The value is unparseable! Introduce the data correctly!");
        }
        System.out.println();
        showMenu();
    }

    public static void updateEmployee(){
        System.out.println("Introduce the employee's id: ");
        int id = input.nextInt();
        System.out.println("Introduce the new last name: ");
        String lastName = input.next();
        sqlEmployeeRepository.updateEmployeeData(id, lastName);
        System.out.println("The name was updated successfully!");
    }
}
