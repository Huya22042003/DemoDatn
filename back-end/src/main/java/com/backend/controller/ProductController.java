package com.backend.controller;

import com.backend.entity.Product;
import com.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<Product> getList() {
        return service.getList();
    }

    @GetMapping("/{id}")
    public Product findByIndex(@PathVariable("id") int index) {
        if(index > service.getList().size() || index < 0) {
            return null;
        }
        return service.getList().get(index);
    }

    @PostMapping("")
    public boolean add(@RequestBody Product product) {
        return service.create(product);
    }

    @PutMapping("/{id}")
    public boolean update(@RequestBody Product product, @PathVariable("id") int index) {
        return service.update(product, index);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int index) {
        return service.delete(index);
    }

}
