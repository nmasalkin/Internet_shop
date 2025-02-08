package ru.vsu.cs.masalkin.internet_shop.app.mapper;

import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setSize(productDto.getSize());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getTitle(),
                product.getPrice(),
                product.getWeight(),
                product.getSize(),
                product.getDescription());
        productDto.setId(product.getId());
        return productDto;
    }
}
