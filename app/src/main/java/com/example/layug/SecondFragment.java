package com.example.layug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.layug.databinding.FragmentSecondBinding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static class Account {
        private String username;
        private String password;

        // Constructor to initialize a new account
        public Account(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class AccountManager {

        private static Map<String, android.accounts.Account> database = new HashMap<>();


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
            android.accounts.Account newUser = new android.accounts.Account(username, password);
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
}