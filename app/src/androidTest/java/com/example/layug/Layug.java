package com.example.layug;

import java.util.Scanner;

public class Layug {
    public static void main(String[] args) {
        ClassLayug manager = new ClassLayug();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Welcome to the Account System ---");

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Account (Register)");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter new username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String regPass = scanner.nextLine();
                    manager.registerUser(regUser, regPass);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = scanner.nextLine();
                    manager.loginUser(loginUser, loginPass);
                    break;

                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
        scanner.close();
    }
}