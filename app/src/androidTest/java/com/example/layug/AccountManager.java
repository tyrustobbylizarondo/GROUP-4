package com.example.layug;

import android.accounts.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManager {

    private static Map<String, Account> database = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to Account System ---");
            System.out.println("1. Create Account");
            System.out.println("2. View Registered Accounts");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    displayAccounts();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine().trim();
        if (database.containsKey(username)) {
            System.out.println("Error: That username is already taken!");
            return;
        }
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        Account newUser = new Account(username, password);
        database.put(username, newUser);

        String Date = scanner.nextLine();;
        System.out.println("Success! Account created for: " + username);
    }
    private static void displayAccounts() {
        if (database.isEmpty()) {
            System.out.println("No accounts registered yet.");
            return;
        }
        System.out.println("Registered Usernames:");
        for (String username : database.keySet()) {
            System.out.println("- " + username);
        }
    }
}