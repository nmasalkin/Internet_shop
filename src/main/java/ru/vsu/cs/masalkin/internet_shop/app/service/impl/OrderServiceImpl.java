package ru.vsu.cs.masalkin.internet_shop.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderDto;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.OrderMapper;
import ru.vsu.cs.masalkin.internet_shop.app.service.OrderService;
import ru.vsu.cs.masalkin.internet_shop.data.CustomerRepository;
import ru.vsu.cs.masalkin.internet_shop.data.OrderRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderDto save(OrderDto order) {
        Order orderEntity = orderRepository.save(OrderMapper.toEntity(order));
        return OrderMapper.toDto(orderEntity);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto findById(Integer id) {
        return OrderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found")));
    }

    @Override
    public Iterable<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            order.setCustomer(customerRepository.findById(order.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer not found")));
        }
        return orders.stream().sorted(((o1, o2) -> o2.getId().compareTo(o1.getId()))).map(OrderMapper::toDto).toList();
    }

}
