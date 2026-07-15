package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repo;

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repo.findByCategory(category);
    }
}