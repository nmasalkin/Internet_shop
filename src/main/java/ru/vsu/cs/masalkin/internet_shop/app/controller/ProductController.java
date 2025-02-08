package ru.vsu.cs.masalkin.internet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    public ProductDto save(ProductDto product) {
        return productService.save(product);
    }

    public void delete(Integer id) {
        productService.delete(id);
    }

    public ProductDto findById(Integer id) {
        return productService.findById(id);
    }

    public Iterable<ProductDto> findByTitle(String title) {
        return productService.findByTitle(title);
    }

    public Iterable<ProductDto> findAll() {
        return productService.findAll();
    }
}
