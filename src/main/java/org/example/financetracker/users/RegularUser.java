package org.example.financetracker.users;

public class RegularUser extends User {
    /**
     * ==
     * @param username
     * @param password
     * @param email
     */
    public RegularUser(String username, String password, String email) {
        super(username, password, email);
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

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }
}
