package ru.vsu.cs.masalkin.internet_shop.app.service.impl;

import ru.vsu.cs.masalkin.internet_shop.api.model.CartDto;
import ru.vsu.cs.masalkin.internet_shop.app.service.CartService;
import ru.vsu.cs.masalkin.internet_shop.data.model.CartId;

import java.util.List;

public class CartServiceImpl implements CartService {


    @Override
    public CartDto save(CartDto cartDto) {
        return null;
    }

    @Override
    public CartDto delete(CartId cartId) {
        return null;
    }

    @Override
    public CartDto findById(CartId cartId) {
        return null;
    }

    @Override
    public List<CartDto> findAllByCustomerId(Integer customerId) {
        return List.of();
    }
}
