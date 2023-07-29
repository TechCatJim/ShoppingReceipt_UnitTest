package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductsLibrary productsLibrary = new ProductsLibrary();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your location in State of US (CA or NY):");
        String location = scanner.nextLine();

        ShoppingCart cart = new ShoppingCart(location);

        while (true) {
            System.out.println("Enter product name (or 'done' to finish):");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("done")) {
                break;
            }

            Product product = productsLibrary.getProduct(productName);
            if (product == null) {
                System.out.println("Product not found. Please try again.");
                continue;
            }

            System.out.println("Enter product quantity:");
            int quantity = scanner.nextInt();

            // Consume newline left-over
            scanner.nextLine();

            cart.addProduct(product, quantity);
        }

        cart.printReceipt();

        scanner.close();
    }

}