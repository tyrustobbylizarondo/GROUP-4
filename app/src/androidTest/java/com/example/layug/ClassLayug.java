package com.example.layug;

import java.util.HashMap;
import java.util.Map;

class ClassLayug {

    private Map<String, UserLayug> userDatabase = new HashMap<>();


    public boolean registerUser(String username, String password) {
        if (username.isBlank() || password.length() < 4) {
            System.out.println("Invalid input! Password must be at least 4 characters.");
            return false;
        }

        if (userDatabase.containsKey(username)) {
            System.out.println("Registration failed. Username already exists!");
            return false;
        }

        UserLayug newUser = new UserLayug(username, password);
        userDatabase.put(username, newUser);
        System.out.println("Account successfully created for: " + username);
        return true;
    }


    public boolean loginUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            UserLayug user = userDatabase.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome back, " + username + ".");
                return true;
            }
        }
        System.out.println( "Invalid username or password.");
        return false;
    }
}

