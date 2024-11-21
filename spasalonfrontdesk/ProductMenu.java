package com.mycompany.spasalonfrontdesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {

    public static void main(String[] args) {
        showMainMenu();
    }


    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Spa and Salon Front Desk System ---");
            System.out.println("1. Show Products");
            System.out.println("2. Show Salon Services");
            System.out.println("3. Show Spa Services");
            System.out.println("4. About Us");
            System.out.println("5. Contact");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showProductsMenu();
                    break;
                case 2:
                    showSalonServices();
                    break;
                case 3:
                    showSpaServices();
                    break;
                case 4:
                    aboutUs();
                    break;
                case 5:
                    contact();
                    break;
                case 6:
                    System.out.println("Thank you for visiting! Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void showProductsMenu() {
        Scanner scanner = new Scanner(System.in);
        List<OrderItem> cart = new ArrayList<>(); 
        boolean continueShopping = true;


        while (continueShopping) {
            System.out.println("\n--- Products ---");
            System.out.println("1. Hair Care");
            System.out.println("2. Body Care");
            System.out.print("Select a product category (1-2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showHairCareProducts(scanner, cart);
                    break;
                case 2:
                    showBodyCareProducts(scanner, cart);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Would you like to order something else? (yes/no): ");
                String orderChoice = scanner.nextLine().toLowerCase();

                if (orderChoice.equals("yes")) {
                    validResponse = true; 
                } else if (orderChoice.equals("no")) {
                    validResponse = true; 
                    showReceipt(cart); 
                    returnToMainMenu();  
                    break;  
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }
    }

    
    private static void showHairCareProducts(Scanner scanner, List<OrderItem> cart) {
        double price = 0;
        String productName = "";
        System.out.println("\n--- Hair Care Products ---");
        System.out.println("1. Anti Hair Fall - 500 pesos");
        System.out.println("2. Curl Enhancer - 400 pesos");
        System.out.println("3. Fortifying with Color Protect - 600 pesos");
        System.out.print("Select a hair care product (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                price = 500;
                productName = "Anti Hair Fall";
                System.out.println("You selected Anti Hair Fall - 500 pesos");
                break;
            case 2:
                price = 400;
                productName = "Curl Enhancer";
                System.out.println("You selected Curl Enhancer - 400 pesos");
                break;
            case 3:
                price = 600;
                productName = "Fortifying with Color Protect";
                System.out.println("You selected Fortifying with Color Protect - 600 pesos");
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                return;
        }

        
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        
        cart.add(new OrderItem(productName, price, quantity));
        System.out.println("Total for this product: " + (price * quantity) + " pesos");
    }

    
    private static void showBodyCareProducts(Scanner scanner, List<OrderItem> cart) {
        double price = 0;
        String productName = "";
        System.out.println("\n--- Body Care Products ---");
        System.out.println("1. Clear Exfoliating Beauty Bar - 200 pesos");
        System.out.println("2. Pure Nourishing Beauty Bar - 210 pesos");
        System.out.println("3. Renew Revitalizing Beauty Bar - 250 pesos");
        System.out.print("Select a body care product (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                price = 200;
                productName = "Clear Exfoliating Beauty Bar";
                System.out.println("You selected Clear Exfoliating Beauty Bar - 200 pesos");
                break;
            case 2:
                price = 210;
                productName = "Pure Nourishing Beauty Bar";
                System.out.println("You selected Pure Nourishing Beauty Bar - 210 pesos");
                break;
            case 3:
                price = 250;
                productName = "Renew Revitalizing Beauty Bar";
                System.out.println("You selected Renew Revitalizing Beauty Bar - 250 pesos");
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                return;
        }

        
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        
        cart.add(new OrderItem(productName, price, quantity));
        System.out.println("Total for this product: " + (price * quantity) + " pesos");
    }

    
    private static void showReceipt(List<OrderItem> cart) {
        double totalPrice = 0;
        System.out.println("\n--- Receipt ---");
        System.out.println("Items purchased:");
        
        
        for (OrderItem item : cart) {
            double itemTotal = item.getPrice() * item.getQuantity();
            System.out.println(item.getName() + " (x" + item.getQuantity() + ") - " + item.getPrice() + " pesos each | Total: " + itemTotal + " pesos");
            totalPrice += itemTotal;
        }

        
        System.out.println("\nTotal Order Price: " + totalPrice + " pesos");
    }

    
    private static void returnToMainMenu() {
        System.out.println("\nReturning to the main menu...");
        showMainMenu();  
    }

    
    private static void showSalonServices() {
        System.out.println("\n--- Salon Services ---");
        System.out.println("1. Hair Cutting");
        System.out.println("2. Hair Coloring");
        System.out.println("3. Make-up");
        System.out.print("Please select a salon service: ");
    }

    
    private static void showSpaServices() {
        System.out.println("\n--- Spa Services ---");
        System.out.println("1. Skin Care Treatments");
        System.out.println("2. Massage Treatments");
        System.out.print("Please select a spa service: ");
    }

    
    private static void aboutUs() {
        System.out.println("\n--- About Us ---");
        System.out.println("We are a premium spa and salon service provider.");
    }

    
    private static void contact() {
        System.out.println("\n--- Contact ---");
        System.out.println("Contact us at: 123-456-7890 or visit our website.");
    }

    
    static class OrderItem {
        private String name;
        private double price;
        private int quantity;

        public OrderItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
