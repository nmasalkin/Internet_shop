package ru.vsu.cs.masalkin.internet_shop.app.service;

import ru.vsu.cs.masalkin.internet_shop.api.model.OrderDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.Order;

public interface OrderService {

    OrderDto save(OrderDto order);

    void delete(Integer id);

    OrderDto findById(Integer id);

    Iterable<OrderDto> findAll();
}
