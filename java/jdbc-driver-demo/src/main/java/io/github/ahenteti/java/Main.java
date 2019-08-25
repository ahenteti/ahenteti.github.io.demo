package io.github.ahenteti.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc driver demo
 *
 */
public class Main 
{
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "<username>", "<password>")) {
            System.out.println("connected to PostgreSQL database with success");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT true AS IS_ALIVE");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", "IS_ALIVE", resultSet.getBoolean("IS_ALIVE"));
            }
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }
}
