package com.productmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
  private static final String URL = "jdbc:postgresql://localhost:5432/myDatabase";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    // Establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Create (Insert) a new product
    public void addProduct(Product product) {
        String sql = "INSERT INTO Product (name, type, place, warranty) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getType());
            pstmt.setString(3, product.getPlace());
            pstmt.setInt(4, product.getWarranty());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Select) all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("place"),
                    rs.getInt("warranty")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Read (Select) product by name
    public Product getProductByName(String name) {
        String sql = "SELECT * FROM Product WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Product( 
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("place"),
                    rs.getInt("warranty")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update product
    public void updateProduct(Product product) {
        String sql = "UPDATE Product SET type = ?, place = ?, warranty = ? WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getType());
            pstmt.setString(2, product.getPlace());
            pstmt.setInt(3, product.getWarranty());
            pstmt.setString(4, product.getName());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete product
    public void deleteProduct(String name) {
        String sql = "DELETE FROM Product WHERE name = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get products by place
    public List<Product> getProductsByPlace(String place) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE place = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, place);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("place"),
                    rs.getInt("warranty")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Get products by warranty
    public List<Product> getProductsByWarranty(int warranty) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE warranty = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, warranty);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("place"),
                    rs.getInt("warranty")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
