package com.productmanagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Product Management System =====");
            System.out.println("1. Add a new product");
            System.out.println("2. Display all products");
            System.out.println("3. Search product by name");
            System.out.println("4. Update a product");
            System.out.println("5. Delete a product");
            System.out.println("6. Search products by place");
            System.out.println("7. Search products by warranty");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct(scanner, productService);
                    break;
                case 2:
                    displayAllProducts(productService);
                    break;
                case 3:
                    searchProductByName(scanner, productService);
                    break;
                case 4:
                    updateProduct(scanner, productService);
                    break;
                case 5:
                    deleteProduct(scanner, productService);
                    break;
                case 6:
                    searchProductsByPlace(scanner, productService);
                    break;
                case 7:
                    searchProductsByWarranty(scanner, productService);
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addProduct(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Add a New Product -----");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product type: ");
        String type = scanner.nextLine();
        System.out.print("Enter product place: ");
        String place = scanner.nextLine();
        System.out.print("Enter product warranty year: ");
        int warranty = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product(name, type, place, warranty);
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void displayAllProducts(ProductService productService) {
        System.out.println("\n----- All Products -----");
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found in the database.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void searchProductByName(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Search Product by Name -----");
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();

        Product product = productService.getProductByName(name);
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("No product found with name: " + name);
        }
    }

    private static void updateProduct(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Update a Product -----");
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();

        Product product = productService.getProductByName(name);
        if (product != null) {
            System.out.println("Current product details: " + product);
            
            System.out.print("Enter new product type: ");
            String type = scanner.nextLine();
            System.out.print("Enter new product place: ");
            String place = scanner.nextLine();
            System.out.print("Enter new product warranty year: ");
            int warranty = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            product.setType(type);
            product.setPlace(place);
            product.setWarranty(warranty);
            
            productService.updateProduct(product);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("No product found with name: " + name);
        }
    }

    private static void deleteProduct(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Delete a Product -----");
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();

        Product product = productService.getProductByName(name);
        if (product != null) {
            productService.deleteProduct(name);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("No product found with name: " + name);
        }
    }

    private static void searchProductsByPlace(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Search Products by Place -----");
        System.out.print("Enter place to search: ");
        String place = scanner.nextLine();

        List<Product> products = productService.getProductsByPlace(place);
        if (products.isEmpty()) {
            System.out.println("No products found in place: " + place);
        } else {
            System.out.println("Products in " + place + ":");
            products.forEach(System.out::println);
        }
    }

    private static void searchProductsByWarranty(Scanner scanner, ProductService productService) {
        System.out.println("\n----- Search Products by Warranty -----");
        System.out.print("Enter warranty year to search: ");
        int warranty = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Product> products = productService.getProductsByWarranty(warranty);
        if (products.isEmpty()) {
            System.out.println("No products found with warranty year: " + warranty);
        } else {
            System.out.println("Products with warranty year " + warranty + ":");
            products.forEach(System.out::println);
        }
    }
}