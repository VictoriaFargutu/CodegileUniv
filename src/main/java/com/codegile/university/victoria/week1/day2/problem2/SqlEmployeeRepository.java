package com.codegile.university.victoria.week1.day2.problem2;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SqlEmployeeRepository implements EmployeeRepository {

    public  Connection connection = null;
    CallableStatement callableStatement = null;

    public void makeDBConnection(){

            String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName);

            String url = "jdbc:mysql://localhost:3306/company";

            String username = "root";
            String password = "VictoriaFargutu";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void createEmployee(String employeeFirstName, String employeeLastName, String employeeCnp, Date employeeBirthday) {
        makeDBConnection();
        try {
            String createQuery = "INSERT INTO employee(firstName, lastName, cnp, birthday) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, employeeFirstName);
            preparedStatement.setString(2, employeeLastName);
            preparedStatement.setString(3, employeeCnp);
            preparedStatement.setDate(4, employeeBirthday);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readEmployeesBornAfterEighties() {
        makeDBConnection();

        try {
            String createQuery = "SELECT * FROM employee WHERE birthday > '198%'";
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String ssn = resultSet.getString("cnp");
                Date birthday = resultSet.getDate("birthday");
                Employee employee = new Employee(firstName, lastName, ssn, birthday);
                System.out.println(employee.toString());
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> readEmployeesBornYearDescending() {
        makeDBConnection();
        List<Employee> employeesDescendingOrder = new ArrayList<>();

        try {
            String createQuery = "SELECT * FROM company.employee";
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String ssn = resultSet.getString("cnp");
                Date birthday = resultSet.getDate("birthday");
                Employee employee = new Employee(firstName, lastName, ssn, birthday);
                employeesDescendingOrder.add(employee);
                System.out.println(employee.toString());
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesDescendingOrder;
    }

    @Override
    public void updateEmployeeData(int id, String employeeLasName) {
        makeDBConnection();
        try {
//            callableStatement = connection.prepareCall("{call updateEmployeeFirstName(?)}");
//           callableStatement.setString("name", "Mirabela");
//            callableStatement.execute();
            String query = "UPDATE employee SET lastName = ? where idEmployee=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeLasName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        makeDBConnection();
        try {
            String createQuery = "DELETE FROM employee WHERE idEmployee = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
