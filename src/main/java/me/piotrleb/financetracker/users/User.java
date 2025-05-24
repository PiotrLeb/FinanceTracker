package me.piotrleb.financetracker.users;

import me.piotrleb.financetracker.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private String username;
    private String password;
    private float balance;
    private float income;
    private float savings;
    private float expenses;

    public User(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT balance, income, savings, expenses FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.balance = rs.getFloat("balance");
                this.income = rs.getFloat("income");
                this.savings = rs.getFloat("savings");
                this.expenses = rs.getFloat("expenses");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(String username, String password) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password) VALUES(?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " rows affected");
            } else {
                System.out.println("No rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserExist(String username, String password) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT username FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isUsernameExist(String username) throws SQLException {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT username FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return true;
                }
            }
            return false;
        }
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public float getBalance() {
        return balance;
    }
    public float getIncome() {
        return income;
    }
    public float getSavings() {
        return savings;
    }
    public float getExpenses() {
        return expenses;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setIncome(float income) {
        this.income = income;
    }
    public void setSavings(float savings) {
        this.savings = savings;
    }
    public void setExpenses(float expenses) {
        this.expenses = expenses;
    }
}
