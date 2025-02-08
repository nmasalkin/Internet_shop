package ru.vsu.cs.masalkin.internet_shop.api.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.masalkin.internet_shop.api.model.*;
import ru.vsu.cs.masalkin.internet_shop.app.controller.CustomerController;
import ru.vsu.cs.masalkin.internet_shop.app.controller.OrderController;
import ru.vsu.cs.masalkin.internet_shop.app.controller.OrderProductController;
import ru.vsu.cs.masalkin.internet_shop.app.controller.ProductController;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.CustomerMapper;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.OrderMapper;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.ProductMapper;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;
import ru.vsu.cs.masalkin.internet_shop.data.model.OrderProductId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cartDtos")
public class CreateOrderController {

    @Autowired
    private ProductController productController;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private OrderController orderController;

    @Autowired
    private OrderProductController orderProductController;

    @GetMapping("/CreateOrder")
    public String CreateOrder(Model model) {
        List<CartDto> cartDtos = (List<CartDto>) model.getAttribute("cartDtos");
        model.addAttribute("cartDtos", cartDtos);
        return "CreateOrder";
    }

    @PostMapping("/Catalog/makeOrder")
    public String MakeOrder(@RequestParam("cart-data") String cartDataJson, Model model) throws JsonProcessingException {
        List<CartItem> cartItems = new ObjectMapper().readValue(cartDataJson, new TypeReference<List<CartItem>>() {});
        List<CartDto> cartDtos = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            CartDto cartDto = new CartDto(new Customer(), ProductMapper.toEntity(productController.findById(Integer.parseInt(cartItem.getId()))), cartItem.getQuantity());
            cartDtos.add(cartDto);
        }
        model.addAttribute("cartDtos", cartDtos);
        return "redirect:/CreateOrder";
    }

    @PostMapping("/CreateOrder/createOrder")
    public String CreateOrder(@ModelAttribute("newOrderForm") OrderForm orderForm, Model model) {
        CustomerDto customerDto = customerController.findByEmail(orderForm.getEmail());
        if (customerDto == null) {
            customerDto = new CustomerDto(orderForm.getFirstName(), orderForm.getLastName(), orderForm.getPatronymic(), orderForm.getAddress(), orderForm.getPhoneNumber(), orderForm.getEmail());
            customerController.save(customerDto);
        }

        OrderDto orderDto = new OrderDto(CustomerMapper.toEntity(customerDto), LocalDate.now(), (int) orderForm.getShippingCost(), (int) orderForm.getTotalAmount(), orderForm.getPaymentMethod(), "Обрабатывается");
        if (orderDto.getPaymentMethod().equals("cash")){
            orderDto.setPaymentMethod("Наличными при получении");
        } else if (orderDto.getPaymentMethod().equals("card")) {
            orderDto.setPaymentMethod("Картой при получении");
        } else {
            orderDto.setPaymentMethod("Онлайн-оплата");
        }
        orderDto = orderController.save(orderDto);

        List<CartDto> cartDtos = (List<CartDto>) model.getAttribute("cartDtos");
        for (CartDto cartDto : cartDtos) {
            OrderProductId orderProductId = new OrderProductId();
            orderProductId.setOrderId(orderDto.getId());
            orderProductId.setProductId(cartDto.getProduct().getId());
            OrderProductDto orderProductDto = new OrderProductDto(OrderMapper.toEntity(orderDto), cartDto.getProduct(), cartDto.getQuantity());
            orderProductDto.setId(orderProductId);
            orderProductController.save(orderProductDto);
        }

        return "redirect:/Catalog";
    }
}
