package org.example.financetracker.users;

public class Admin extends User {
    /**
     *
     * @param username
     * @param password
     */
    public Admin(String username, String password) {
        super(username, password);
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

}
