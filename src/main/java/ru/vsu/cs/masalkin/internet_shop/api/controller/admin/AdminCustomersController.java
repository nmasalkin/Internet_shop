package ru.vsu.cs.masalkin.internet_shop.api.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;
import ru.vsu.cs.masalkin.internet_shop.app.controller.CustomerController;

@Controller
public class AdminCustomersController {

    @Autowired
    private CustomerController customerController;

    @GetMapping("/AdminCustomers")
    public String Customers(Model model) {
        Iterable<CustomerDto> customers = customerController.findAll();
        model.addAttribute("customers", customers);
        return "AdminCustomers";
    }

    @GetMapping("/AdminCustomers/searchCustomer")
    public String searchCustomer(@RequestParam("fullname") String name, Model model) {
        Iterable<CustomerDto> customers = customerController.findByFullName(name);
        model.addAttribute("customers", customers);
        return "AdminCustomers";
    }

    @PostMapping("/AdminCustomers/saveCustomer")
    public String saveProduct(@ModelAttribute("newCustomer") CustomerDto customer) {
        if (customer.getPatronymic().equals("")) {
            customer.setPatronymic(null);
        }
        customerController.save(customer);
        return "redirect:/AdminCustomers";
    }

    @PostMapping("/AdminCustomers/editCustomer")
    public String editProduct(@ModelAttribute("customer") CustomerDto customer) {
        if (customer.getPatronymic().equals("")) {
            customer.setPatronymic(null);
        }
        customerController.save(customer);
        return "redirect:/AdminCustomers";
    }

    @PostMapping("/AdminCustomers/deleteCustomer")
    public String deleteProduct(@ModelAttribute("id") Integer id) {
        customerController.delete(id);
        return "redirect:/AdminCustomers";
    }

}
