package dao;

import entities.Product;

import java.util.List;

public interface IProductDao {
    Product addProduct(Product product) throws Exception;
    Product updateProduct(Product product) throws Exception;
    Product removeProduct(Product product) throws Exception;
    Product getProductById(int id) throws Exception;
    List<Product> getProducts() throws Exception;
}
