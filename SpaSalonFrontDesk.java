package com.mycompany.spasalonfrontdesk;

import java.util.Scanner;

public class SpaSalonFrontDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ProductMenu.showProductsMenu();
                    break;
                case 2:
                    SalonServicesMenu.showSalonServicesMenu();
                    break;
                case 3:
                    SpaServicesMenu.showSpaServicesMenu();
                    break;
                case 4:
                    AboutUs.showAboutUs();
                    break;
                case 5:
                    ContactInfo.showContactInfo();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for visiting the Spa and Salon!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Main Menu
    public static void showMainMenu() {
        System.out.println("\n--- Spa and Salon Front Desk System ---");
        System.out.println("1. Show Products");
        System.out.println("2. Show Salon Services");
        System.out.println("3. Show Spa Services");
        System.out.println("4. About Us");
        System.out.println("5. Contact");
        System.out.println("6. Exit");
        System.out.print("Please select an option: ");
    }
    
}
