package ru.vsu.cs.masalkin.internet_shop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Cart;
import ru.vsu.cs.masalkin.internet_shop.data.model.CartId;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}
