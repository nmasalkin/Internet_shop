package ru.vsu.cs.masalkin.internet_shop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
