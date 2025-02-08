package ru.vsu.cs.masalkin.internet_shop.app.service;

import ru.vsu.cs.masalkin.internet_shop.api.model.OrderProductDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProduct;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;

public interface OrderProductService {

    OrderProductDto save(OrderProductDto orderProduct);

    void delete(OrderProductId id);

    void deleteAllByOrderId(Integer orderId);

    OrderProductDto findById(OrderProductId id);

    Iterable<OrderProductDto> findAllByOrderId(Integer orderId);

    Iterable<OrderProductDto> findAll();
}
