package ru.vsu.cs.masalkin.internet_shop.app.service;

import ru.vsu.cs.masalkin.internet_shop.api.model.CartDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.CartId;

import java.util.List;

public interface CartService {

    CartDto save(CartDto cartDto);

    CartDto delete(CartId cartId);

    CartDto findById(CartId cartId);

    List<CartDto> findAllByCustomerId(Integer customerId);
}
