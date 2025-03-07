package com.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a new product
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully!");
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Get product by name
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    // Update product
    @PutMapping("/{name}")
    public ResponseEntity<?> updateProduct(@PathVariable String name, @RequestBody Product updatedProduct) {
        Product existingProduct = productService.getProductByName(name);
        if (existingProduct != null) {
            existingProduct.setType(updatedProduct.getType());
            existingProduct.setPlace(updatedProduct.getPlace());
            existingProduct.setWarranty(updatedProduct.getWarranty());
            productService.updateProduct(existingProduct);
            return ResponseEntity.ok("Product updated successfully!");
        }
        return ResponseEntity.notFound().build();
    }

    // Delete product
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteProduct(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            productService.deleteProduct(name);
            return ResponseEntity.ok("Product deleted successfully!");
        }
        return ResponseEntity.notFound().build();
    }

    // Search products by place
    @GetMapping("/place/{place}")
    public ResponseEntity<List<Product>> getProductsByPlace(@PathVariable String place) {
        List<Product> products = productService.getProductsByPlace(place);
        return ResponseEntity.ok(products);
    }

    // Search products by warranty
    @GetMapping("/warranty/{warranty}")
    public ResponseEntity<List<Product>> getProductsByWarranty(@PathVariable int warranty) {
        List<Product> products = productService.getProductsByWarranty(warranty);
        return ResponseEntity.ok(products);
    }
} 