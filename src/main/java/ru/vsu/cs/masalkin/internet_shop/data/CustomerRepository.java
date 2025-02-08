package ru.vsu.cs.masalkin.internet_shop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.masalkin.internet_shop.data.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrPatronymicContainingIgnoreCase(String firstName, String lastName, String patronymic);

    Customer findByEmail(String email);
}
