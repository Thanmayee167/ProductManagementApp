package com.productmanagement;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByPlace(String place) {
        return products.stream()
                .filter(product -> product.getPlace().equalsIgnoreCase(place))
                .toList();
    }

    public List<Product> getProductsByWarranty(String warranty) {
        return products.stream()
                .filter(product -> product.getWaranty().equals(warranty))
                .toList();
    }
}