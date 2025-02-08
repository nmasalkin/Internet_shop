package ru.vsu.cs.masalkin.internet_shop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProduct;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}
