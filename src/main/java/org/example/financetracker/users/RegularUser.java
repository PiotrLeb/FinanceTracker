package org.example.financetracker.users;

public class RegularUser extends User {

    public RegularUser(String username, String password, String email) {
        super(username, password, email);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
