package ru.vsu.cs.masalkin.internet_shop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product>findByTitleContainingIgnoreCase(String title);
}
