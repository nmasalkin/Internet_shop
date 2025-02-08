package ru.vsu.cs.masalkin.internet_shop.app.mapper;

import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPatronymic(customerDto.getPatronymic());
        customer.setAddress(customerDto.getAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public static CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPatronymic(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getEmail());
        customerDto.setId(customer.getId());
        return customerDto;
    }
}
