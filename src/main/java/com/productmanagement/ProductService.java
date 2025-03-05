package com.productmanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired ProductRepository productRepository;

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

  public List<Product> findAll() {
    return productRepository.findAll();
  }
}
