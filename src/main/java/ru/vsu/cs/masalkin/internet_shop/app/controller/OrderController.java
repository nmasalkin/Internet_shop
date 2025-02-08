package ru.vsu.cs.masalkin.internet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderDto;
import ru.vsu.cs.masalkin.internet_shop.app.service.OrderProductService;
import ru.vsu.cs.masalkin.internet_shop.app.service.impl.OrderProductServiceImpl;
import ru.vsu.cs.masalkin.internet_shop.app.service.impl.OrderServiceImpl;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderProductServiceImpl orderProductService;

    public OrderDto save(OrderDto order) {
        return orderService.save(order);
    }

    public void delete(Integer id) {
        orderService.delete(id);
    }

    public OrderDto findById(Integer id) {
        return orderService.findById(id);
    }

    public Iterable<OrderDto> findAll() {
        return orderService.findAll();
    }
}
