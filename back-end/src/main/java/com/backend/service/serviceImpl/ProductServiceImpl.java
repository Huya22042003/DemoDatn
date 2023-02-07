package com.backend.service.serviceImpl;

import com.backend.entity.Product;
import com.backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> list;

    public ProductServiceImpl() {
        list = new ArrayList<>();
        list.add(new Product(1, "Sản phẩm 1", 10000));
        list.add(new Product(2, "Sản phẩm 2", 10000));
        list.add(new Product(3, "Sản phẩm 3", 10000));
        list.add(new Product(4, "Sản phẩm 4", 10000));
        list.add(new Product(5, "Sản phẩm 5", 10000));
    }

    @Override
    public List<Product> getList() {
        return list;
    }

    @Override
    public boolean create(Product product) {
        list.add(product);
        return true;
    }

    @Override
    public boolean update(Product product, int index) {
        list.set(index, product);
        return true;
    }

    @Override
    public boolean delete(int index) {
        list.remove(index);
        return true;
    }
}
