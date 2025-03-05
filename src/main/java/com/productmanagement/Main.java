package com.productmanagement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        // Adding 15 different products
        productService.addProduct(new Product("Macbook Pro", "Laptop", "Office", "2025"));
        productService.addProduct(new Product("iPhone 15", "Smartphone", "Store", "2026"));
        productService.addProduct(new Product("Samsung TV", "Electronics", "Living Room", "2027"));
        productService.addProduct(new Product("Dell Monitor", "Display", "Office", "2025"));
        productService.addProduct(new Product("Sony Headphones", "Audio", "Store", "2024"));
        productService.addProduct(new Product("Gaming Chair", "Furniture", "Gaming Room", "2026"));
        productService.addProduct(new Product("Mechanical Keyboard", "Input Device", "Office", "2024"));
        productService.addProduct(new Product("Wireless Mouse", "Input Device", "Office", "2024"));
        productService.addProduct(new Product("iPad Pro", "Tablet", "Store", "2026"));
        productService.addProduct(new Product("AirPods", "Audio", "Store", "2024"));
        productService.addProduct(new Product("Printer", "Office Equipment", "Office", "2025"));
        productService.addProduct(new Product("Smart Watch", "Wearable", "Store", "2024"));
        productService.addProduct(new Product("Security Camera", "Security", "Entrance", "2026"));
        productService.addProduct(new Product("Router", "Networking", "Server Room", "2025"));
        productService.addProduct(new Product("External SSD", "Storage", "Office", "2027"));

        // Display all products
        List<Product> products = productService.getAllProducts();
        System.out.println("All Products:");
        products.forEach(System.out::println);

        // Search for products by place
        String place = "Office";
        List<Product> officeProducts = productService.getProductsByPlace(place);
        System.out.println("\nProducts in the " + place + " place:");
        officeProducts.forEach(System.out::println);

        // Search for products for out of warranty
        String outOfWarranty = "2024";
        List<Product> outOfWarrantyProducts = productService.getProductsByWarranty(outOfWarranty);
        System.out.println("\nProducts out of warranty:");
        outOfWarrantyProducts.forEach(System.out::println);
    }
}