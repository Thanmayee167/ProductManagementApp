package com.productmanagement;

import java.util.List;

public class ProductService {

  ProductDB db = new ProductDB();

  public void addProduct(Product product) {
    db.addProduct(product);
  }

  public List<Product> getAllProducts() {
    return db.getAllProducts();
  }

  public Product getProductByName(String name) {
    return db.getProductByName(name);
  }

  public void updateProduct(Product product) {
    db.updateProduct(product);
  }

  public void deleteProduct(String name) {
    db.deleteProduct(name);
  }

  public List<Product> getProductsByPlace(String place) {
    return db.getProductsByPlace(place);
  }

  public List<Product> getProductsByWarranty(int warranty) {
    // Convert int to String since the DB method expects a String
    return db.getProductsByWarranty(warranty);
  }
}
