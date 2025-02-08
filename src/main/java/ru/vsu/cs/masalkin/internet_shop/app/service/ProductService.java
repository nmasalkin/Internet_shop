package ru.vsu.cs.masalkin.internet_shop.app.service;

import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;

public interface ProductService {

    ProductDto save(ProductDto product);

    void delete(Integer id);

    ProductDto findById(Integer id);

    Iterable<ProductDto> findAll();
}
