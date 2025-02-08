package ru.vsu.cs.masalkin.internet_shop.api.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderDto;
import ru.vsu.cs.masalkin.internet_shop.api.model.OrderProductDto;
import ru.vsu.cs.masalkin.internet_shop.api.model.ProductDto;
import ru.vsu.cs.masalkin.internet_shop.app.controller.OrderController;
import ru.vsu.cs.masalkin.internet_shop.app.controller.OrderProductController;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.CustomerMapper;

@Controller
public class AdminOrdersController {

    @Autowired
    private OrderController orderController;
    @Autowired
    private OrderProductController orderProductController;

    @GetMapping("/AdminOrders")
    public String Orders(Model model) {
        Iterable<OrderDto> orders = orderController.findAll();
        model.addAttribute("orders", orders);
        Iterable<OrderProductDto> orderProducts = orderProductController.findAll();
        model.addAttribute("orderProducts", orderProducts);
        return "AdminOrders";
    }

    @PostMapping("/AdminOrders/addOrder")
    public String addOrder(@ModelAttribute("newOrder") OrderDto order) {
        return "redirect:/AdminOrders";
    }

    @PostMapping("/AdminOrders/editOrder")
    public String editOrder(@ModelAttribute("order") OrderDto orderDto) {
        orderDto.setCustomer(orderController.findById(orderDto.getId()).getCustomer());
        if (orderDto.getPaymentMethod().equals("cash")){
            orderDto.setPaymentMethod("Наличными при получении");
        } else if (orderDto.getPaymentMethod().equals("card")) {
            orderDto.setPaymentMethod("Картой при получении");
        } else {
            orderDto.setPaymentMethod("Онлайн-оплата");
        }
        if (orderDto.getStatus().equals("processing")) {
            orderDto.setStatus("Обрабатывается");
        } else if (orderDto.getStatus().equals("delivered")) {
            orderDto.setStatus("Вручено");
        } else if (orderDto.getStatus().equals("canceled")) {
            orderDto.setStatus("Отменен");
        } else {
            orderDto.setStatus("Доставляется");
        }
        orderController.save(orderDto);
        return "redirect:/AdminOrders";
    }

    @PostMapping("/AdminOrders/deleteOrder")
    public String deleteOrder(@ModelAttribute("id") Integer id) {
        orderProductController.deleteAllByOrderId(id);
        orderController.delete(id);
        return "redirect:/AdminOrders";
    }
}
