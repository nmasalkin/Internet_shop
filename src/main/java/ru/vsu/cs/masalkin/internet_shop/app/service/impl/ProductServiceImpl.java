package ru.vsu.cs.masalkin.internet_shop.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.ProductMapper;
import ru.vsu.cs.masalkin.internet_shop.app.service.ProductService;
import ru.vsu.cs.masalkin.internet_shop.data.ProductRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto product) {
        Product productEntity = productRepository.save(ProductMapper.toEntity(product));
        return ProductMapper.toDto(productEntity);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto findById(Integer id) {
        Product productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toDto(productEntity);
    }

    public Iterable<ProductDto> findByTitle(String title) {
        return productRepository.findByTitleContainingIgnoreCase(title).stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).map(ProductMapper::toDto).toList();
    }

    @Override
    public Iterable<ProductDto> findAll() {
        return productRepository.findAll().stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).map(ProductMapper::toDto).toList();
    }
}
