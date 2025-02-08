package ru.vsu.cs.masalkin.internet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.service.OrderProductService;
import ru.vsu.cs.masalkin.internet_shop.app.service.impl.OrderProductServiceImpl;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;

@RestController
public class OrderProductController {

    @Autowired
    private OrderProductServiceImpl orderProductService;

    public void save(OrderProductDto orderProduct) {
        orderProductService.save(orderProduct);
    }

    public void delete(OrderProductId id) {
        orderProductService.delete(id);
    }

    public void deleteAllByOrderId(Integer orderId) {
        orderProductService.deleteAllByOrderId(orderId);
    }

    public Iterable<OrderProductDto> findAllByOrderId(Integer orderId) {
        return orderProductService.findAllByOrderId(orderId);
    }

    public Iterable<OrderProductDto> findAll() {
        return orderProductService.findAll();
    }

    public OrderProductDto findById(OrderProductId id) {
        return orderProductService.findById(id);
    }
}
