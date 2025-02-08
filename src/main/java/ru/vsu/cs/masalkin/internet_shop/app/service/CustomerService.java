package ru.vsu.cs.masalkin.internet_shop.app.service;

import ru.vsu.cs.masalkin.internet_shop.api.model.CustomerDto;

public interface CustomerService {

    CustomerDto save(CustomerDto customer);

    void delete(Integer id);

    CustomerDto findById(Integer id);

    Iterable<CustomerDto> findAll();
}
