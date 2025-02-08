package ru.vsu.cs.masalkin.internet_shop.app.mapper;

import ru.vsu.cs.masalkin.internet_shop.api.model.OrderDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.Order;

public class OrderMapper {

    public static Order toEntity(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCustomer(orderDto.getCustomer());
        order.setRegistrationDate(orderDto.getRegistrationDate());
        order.setShippingCost(orderDto.getShippingCost());
        order.setOrderCost(orderDto.getOrderCost());
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setStatus(orderDto.getStatus());
        return order;
    }

    public static OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto(order.getCustomer(), order.getRegistrationDate(), order.getShippingCost(), order.getOrderCost(), order.getPaymentMethod(), order.getStatus());
        orderDto.setId(order.getId());
        return orderDto;
    }
}
