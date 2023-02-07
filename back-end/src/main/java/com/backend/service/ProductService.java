package com.backend.service;

import com.backend.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getList();
    public boolean create(Product product);
    public boolean update(Product product, int index);
    public boolean delete(int index);
}
