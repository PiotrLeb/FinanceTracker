package org.example.financetracker.users;

public class Admin extends User {
    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
