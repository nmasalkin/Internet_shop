package ru.vsu.cs.masalkin.internet_shop.app.mapper;

import ru.vsu.cs.masalkin.internet_shop.api.model.OrderProductDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProduct;

public class OrderProductMapper {

    public static OrderProduct toEntity(OrderProductDto orderProductDto) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductDto.getId());
        orderProduct.setOrder(orderProductDto.getOrder());
        orderProduct.setProduct(orderProductDto.getProduct());
        orderProduct.setQuantity(orderProductDto.getQuantity());
        return orderProduct;
    }

    public static OrderProductDto toDto(OrderProduct orderProduct) {
        OrderProductDto orderProductDto = new OrderProductDto(orderProduct.getOrder(), orderProduct.getProduct(), orderProduct.getQuantity());
        orderProductDto.setId(orderProductDto.getId());
        return orderProductDto;
    }
}
