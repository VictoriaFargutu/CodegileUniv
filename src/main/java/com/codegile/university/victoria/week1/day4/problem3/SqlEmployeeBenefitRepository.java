package com.codegile.university.victoria.week1.day4.problem3;

import java.sql.*;

public class SqlEmployeeBenefitRepository implements EmployeeBenefitRepository{

    public Connection connection = null;
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
    public void readBenefitsForAGivenYear(String year) {
        makeDBConnection();
        String query = "SELECT * FROM benefit WHERE date_given like '" + year +"%' ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("benefit_name");
                Date date = resultSet.getDate("date_given");
                Benefit benefit = new Benefit(name, date);
                System.out.println(benefit);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
