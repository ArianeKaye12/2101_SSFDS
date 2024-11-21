package com.mycompany.spasalonfrontdesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpaServicesMenu {
    public static void showSpaServicesMenu() {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0;  // Variable to keep track of the total cost of all reservations
        List<String> servicesList = new ArrayList<>();  // List to track services added to the receipt
        List<String> datesList = new ArrayList<>();     // List to track the dates for each service
        List<String> timesList = new ArrayList<>();     // List to track the times for each service
        List<Double> pricesList = new ArrayList<>();    // List to track the prices of each service
        boolean continueBrowsing = true;

        while (continueBrowsing) {
            System.out.println("\n--- Spa Services ---");
            System.out.println("1. Skin Care Treatments");
            System.out.println("2. Massage Treatments");
            System.out.print("Select a spa service: ");
            int choice = getValidChoice(scanner, 1, 2); // Get valid input between 1 and 2

            switch (choice) {
                case 1:
                    totalCost += showSkinCareTreatments(scanner, servicesList, datesList, timesList, pricesList); // Add skin care treatment cost to total
                    break;
                case 2:
                    totalCost += showMassageTreatments(scanner, servicesList, datesList, timesList, pricesList); // Add massage treatment cost to total
                    break;
                default:
                    System.out.println("Invalid choice. Returning to the main menu.");
            }

            // After a service is selected, ask if the user wants to add another reservation
            if (continueBrowsing) {
                System.out.print("\nWould you like to add another reservation? (yes/no): ");
                String response = scanner.next().toLowerCase();
                if (response.equals("no")) {
                    continueBrowsing = false;
                    System.out.println("\nYou have finished selecting services.");
                    // Show receipt before returning to main menu
                    showReceipt(servicesList, datesList, timesList, pricesList, totalCost);
                    returnToMainMenu();
                } else if (!response.equals("yes")) {
                    System.out.println("Invalid input. Returning to the main menu.");
                    continueBrowsing = false;
                }
            }
        }
    }

    // Generic method to get a valid integer choice within a range
    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }

    // Method to show Skin Care Treatments and ask for the schedule
    private static double showSkinCareTreatments(Scanner scanner, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        System.out.println("\n--- Skin Care Treatments ---");
        System.out.println("1. Facials");
        System.out.println("2. Peels");
        System.out.println("3. Waxing and Hair Removal");
        System.out.print("Select a skin care treatment: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                showFacialTreatments(scanner);
                break;
            case 2:
                price = showPeelTreatments(scanner); // Show Peel Treatments first
                break;
            case 3:
                showWaxingHairRemoval(scanner);
                break;
        }

        // Ask for the date and time, and store them
        System.out.print("Enter the desired date for your treatment (YYYY-MM-DD): ");
        scanner.nextLine(); // Consume the leftover newline character
        String date = scanner.nextLine();

        System.out.print("Enter the desired time for your treatment (HH:MM): ");
        String time = scanner.nextLine();

        // Store the details of the service
        servicesList.add(service);
        datesList.add(date);
        timesList.add(time);
        pricesList.add(price);

        return price;
    }

    // Method to show Peel Treatments and ask for the schedule
    private static double showPeelTreatments(Scanner scanner) {
        System.out.println("\n--- Peel Treatments ---");
        System.out.println("1. Chemical Peel - 1500 pesos");
        System.out.println("2. Fruit Acid Peel - 1200 pesos");
        System.out.println("3. Microdermabrasion - 1800 pesos");
        System.out.print("Select a peel treatment: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 1500;
                service = "Chemical Peel";
                break;
            case 2:
                price = 1200;
                service = "Fruit Acid Peel";
                break;
            case 3:
                price = 1800;
                service = "Microdermabrasion";
                break;
        }

        return price;
    }

    // Method to show Facial Treatments
    private static double showFacialTreatments(Scanner scanner) {
        System.out.println("\n--- Facial Treatments ---");
        System.out.println("1. Classic Facial - 800 pesos");
        System.out.println("2. Anti-aging Facial - 1000 pesos");
        System.out.println("3. Hydrating Facial - 1100 pesos");
        System.out.print("Select a facial treatment: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 1500;
                service = "Classic Facial";
                break;
            case 2:
                price = 1200;
                service = "Anti-aging Facial";
                break;
            case 3:
                price = 1800;
                service = "Hydrating Facial";
                break;
        }

        return price;
    }

    // Method to show Waxing and Hair Removal Treatments
    private static double showWaxingHairRemoval(Scanner scanner) {
        System.out.println("\n--- Waxing and Hair Removal ---");
        System.out.println("1. Eyebrow Shaping - 500 pesos");
        System.out.println("2. Full Body Waxing - 1500 pesos");
        System.out.println("3. Brazilian Waxing - 1800 pesos");
        System.out.print("Select a waxing treatment: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 1500;
                service = "Eyebrow Shaping";
                break;
            case 2:
                price = 1200;
                service = "Full Body Waxing";
                break;
            case 3:
                price = 1800;
                service = "Brazilian Waxing";
                break;
        }

        return price;
    }

    // Method to show Massage Treatments and ask for the schedule
    private static double showMassageTreatments(Scanner scanner, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        System.out.println("\n--- Massage Treatments ---");
        System.out.println("1. Sports Massage");
        System.out.println("2. Swedish Massage");
        System.out.println("3. Thai Massage");
        System.out.print("Select a massage treatment: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                service = "Sports Massage";
                price = 1500;
                break;
            case 2:
                service = "Swedish Massage";
                price = 1800;
                break;
            case 3:
                service = "Thai Massage";
                price = 2000;
                break;
        }

        // Ask for the date and time, and store them
        System.out.print("Enter the desired date for your treatment (YYYY-MM-DD): ");
        scanner.nextLine(); // Consume the leftover newline character
        String date = scanner.nextLine();

        System.out.print("Enter the desired time for your treatment (HH:MM): ");
        String time = scanner.nextLine();

        // Store the details of the service
        servicesList.add(service);
        datesList.add(date);
        timesList.add(time);
        pricesList.add(price);

        return price;
    }

    // Method to show the combined receipt with all treatments
    private static void showReceipt(List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList, double totalCost) {
        System.out.println("\n--- Receipt ---");
        for (int i = 0; i < servicesList.size(); i++) {
            System.out.println("Service: " + servicesList.get(i));
            System.out.println("Scheduled Date: " + datesList.get(i));
            System.out.println("Scheduled Time: " + timesList.get(i));
            System.out.println("Price: " + pricesList.get(i) + " pesos");
            System.out.println();
        }

        System.out.println("Total Price: " + totalCost + " pesos");
        System.out.println("Thank you for your reservations! We look forward to serving you.");
    }

    // Method to return to the main menu
    private static void returnToMainMenu() {
        System.out.println("\nReturning to the main menu...");
        try {
            Thread.sleep(2000); // Pause for 2 seconds before going back
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
          // Assuming you have a method in SpaSalonFrontDesk to return to the main menu
    }
}
