package com.example.productmanager.Repository;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    @Autowired
    private IProductService productService;
   private static final List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Iphone",1200.0,"pro max","japan"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }
}
