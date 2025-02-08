package ru.vsu.cs.masalkin.internet_shop.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;
import ru.vsu.cs.masalkin.internet_shop.app.mapper.CustomerMapper;
import ru.vsu.cs.masalkin.internet_shop.app.service.CustomerService;
import ru.vsu.cs.masalkin.internet_shop.data.CustomerRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto save(CustomerDto customer) {
        Customer customerEntity = customerRepository.save(CustomerMapper.toEntity(customer));
        return CustomerMapper.toDto(customerEntity);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto findById(Integer id) {
        Customer customerEntity = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerMapper.toDto(customerEntity);
    }

    public Iterable<CustomerDto> findByFullName(String lastName, String firstName, String patronymic) {
        return customerRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPatronymicContainingIgnoreCase(firstName, lastName, patronymic).stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).map(CustomerMapper::toDto).toList();
    }

    @Override
    public Iterable<CustomerDto> findAll() {
        return customerRepository.findAll().stream().sorted((o1, o2) -> o2.getId().compareTo(o1.getId())).map(CustomerMapper::toDto).toList();
    }

    public CustomerDto findByEmail(String email) {
        Customer customerEntity = customerRepository.findByEmail(email);
        if (customerEntity == null) {
            return null;
        }
        return CustomerMapper.toDto(customerEntity);
    }
}
