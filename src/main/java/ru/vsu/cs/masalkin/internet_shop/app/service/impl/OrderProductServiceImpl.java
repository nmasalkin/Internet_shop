package ru.vsu.cs.masalkin.internet_shop.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.OrderProductMapper;
import ru.vsu.cs.masalkin.internet_shop.app.service.OrderProductService;
import ru.vsu.cs.masalkin.internet_shop.data.OrderProductRepository;
import ru.vsu.cs.masalkin.internet_shop.data.OrderRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Order;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProduct;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderProductDto save(OrderProductDto orderProduct) {
        OrderProduct orderProductEntity = orderProductRepository.save(OrderProductMapper.toEntity(orderProduct));
        return OrderProductMapper.toDto(orderProductEntity);
    }

    @Override
    public void delete(OrderProductId id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public void deleteAllByOrderId(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        for (OrderProduct orderProduct : orderProductRepository.findAll().stream().filter(orderProduct -> orderProduct.getOrder().getId().equals(order.getId())).toList()) {
            orderProductRepository.deleteById(orderProduct.getId());
        }
    }

    @Override
    public OrderProductDto findById(OrderProductId id) {
        return orderProductRepository.findById(id).map(OrderProductMapper::toDto).orElseThrow(() -> new RuntimeException("OrderProduct not found"));
    }

    @Override
    public Iterable<OrderProductDto> findAllByOrderId(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return orderProductRepository.findAll().stream().filter(orderProduct -> orderProduct.getOrder().getId().equals(order.getId())).map(OrderProductMapper::toDto).toList();
    }

    @Override
    public Iterable<OrderProductDto> findAll() {
        return orderProductRepository.findAll().stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).map(OrderProductMapper::toDto).toList();
    }
}
