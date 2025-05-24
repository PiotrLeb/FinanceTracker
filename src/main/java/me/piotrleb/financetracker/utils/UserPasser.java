package me.piotrleb.financetracker.utils;

import me.piotrleb.financetracker.users.User;

public class UserPasser {

    private static User instance;

    public static synchronized User getInstance() {
        return instance;
    }

    public static synchronized void setInstance(User instance) {
        UserPasser.instance = instance;
    }
}
