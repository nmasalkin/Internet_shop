package ru.vsu.cs.masalkin.internet_shop.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;
import ru.vsu.cs.masalkin.internet_shop.app.service.impl.CustomerServiceImpl;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerDto save(CustomerDto customer) {
        return customerService.save(customer);
    }

    public void delete(Integer id) {
        customerService.delete(id);
    }

    public CustomerDto findById(Integer id) {
        return customerService.findById(id);
    }

    public Iterable<CustomerDto> findByFullName(String name) {
        String[] names = name.split(" ");
        if (names.length == 1) {
            return customerService.findByFullName(names[0], names[0], names[0]);
        } else if (names.length == 2) {
            return customerService.findByFullName(names[0], names[1], names[0]);
        } else {
            return customerService.findByFullName(names[0], names[1], names[2]);
        }
    }

    public Iterable<CustomerDto> findAll() {
        return customerService.findAll();
    }

    public CustomerDto findByEmail(String email) {
        return customerService.findByEmail(email);
    }
}
