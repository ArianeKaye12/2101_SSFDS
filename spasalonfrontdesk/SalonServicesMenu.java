package com.mycompany.spasalonfrontdesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalonServicesMenu {

    public static void showSalonServicesMenu() {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0;  // Variable to keep track of the total cost of all reservations
        List<String> servicesList = new ArrayList<>();  // List to track services added to the receipt
        List<String> datesList = new ArrayList<>();     // List to track the dates for each service
        List<String> timesList = new ArrayList<>();     // List to track the times for each service
        List<Double> pricesList = new ArrayList<>();    // List to track the prices of each service
        boolean continueBrowsing = true;

        while (continueBrowsing) {
            System.out.println("\n--- Salon Services ---");
            System.out.println("1. Cutting");
            System.out.println("2. Hair Color");
            System.out.println("3. Make Up");
            System.out.println("4. Return to Main Menu");
            System.out.print("Select a salon service: ");
            int choice = getValidChoice(scanner, 1, 4); // Get valid input between 1 and 4
            

            switch (choice) {
                case 1:
                    totalCost += showCuttingServices(scanner, servicesList, datesList, timesList, pricesList); // Add cutting service cost to total
                    break;
                case 2:
                    totalCost += showHairColorServices(scanner, servicesList, datesList, timesList, pricesList); // Add hair color service cost to total
                    break;
                case 3:
                    totalCost += showMakeUpServices(scanner, servicesList, datesList, timesList, pricesList); // Add makeup service cost to total
                    break;
                case 4:
                    continueBrowsing = false;
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
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

    // Method to show Cutting Services and ask for the schedule
    private static double showCuttingServices(Scanner scanner, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        System.out.println("\n--- Cutting Services ---");
        System.out.println("1. Men’s Cut - 500 pesos");
        System.out.println("2. Women’s Cut - 600 pesos");
        System.out.println("3. Kids Cut - 400 pesos");
        System.out.print("Select a cutting service: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 500;
                service = "Men’s Cut";
                break;
            case 2:
                price = 600;
                service = "Women’s Cut";
                break;
            case 3:
                price = 400;
                service = "Kids Cut";
                break;
        }

        System.out.println("Price: " + price + " pesos");
        askForSchedule(scanner, service, price, servicesList, datesList, timesList, pricesList);
        return price;
    }

    // Method to show Hair Color Services and ask for the schedule
    private static double showHairColorServices(Scanner scanner, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        System.out.println("\n--- Hair Color Services ---");
        System.out.println("1. Single Process Color - 1000 pesos");
        System.out.println("2. Highlights - 1200 pesos");
        System.out.println("3. Balayage - 1500 pesos");
        System.out.println("4. Ombré - 1400 pesos");
        System.out.print("Select a hair color service: ");
        int choice = getValidChoice(scanner, 1, 4); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 1000;
                service = "Single Process Color";
                break;
            case 2:
                price = 1200;
                service = "Highlights";
                break;
            case 3:
                price = 1500;
                service = "Balayage";
                break;
            case 4:
                price = 1400;
                service = "Ombré";
                break;
        }

        System.out.println("Price: " + price + " pesos");
        askForSchedule(scanner, service, price, servicesList, datesList, timesList, pricesList);
        return price;
    }

    // Method to show Make Up Services and ask for the schedule
    private static double showMakeUpServices(Scanner scanner, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        System.out.println("\n--- Make Up Services ---");
        System.out.println("1. Bridal Make Up - 2000 pesos");
        System.out.println("2. Party Make Up - 1500 pesos");
        System.out.println("3. Day Make Up - 1200 pesos");
        System.out.print("Select a make-up service: ");
        int choice = getValidChoice(scanner, 1, 3); // Get valid input

        double price = 0;
        String service = "";
        switch (choice) {
            case 1:
                price = 2000;
                service = "Bridal Make Up";
                break;
            case 2:
                price = 1500;
                service = "Party Make Up";
                break;
            case 3:
                price = 1200;
                service = "Day Make Up";
                break;
        }

        System.out.println("Price: " + price + " pesos");
        askForSchedule(scanner, service, price, servicesList, datesList, timesList, pricesList);
        return price;
    }

    // Method to ask for the schedule (date and time)
    private static void askForSchedule(Scanner scanner, String service, double price, List<String> servicesList, List<String> datesList, List<String> timesList, List<Double> pricesList) {
        scanner.nextLine();  // Consume the newline left by nextInt()

        // Ask for the date
        System.out.print("Please enter the desired date for your treatment (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        // Ask for the time
        System.out.print("Please enter the desired time for your treatment (HH:MM): ");
        String time = scanner.nextLine();

        // Store the service details
        servicesList.add(service);
        datesList.add(date);
        timesList.add(time);
        pricesList.add(price);
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
