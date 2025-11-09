package com.simportal.service;

import com.simportal.dto.CustomerRegisterRequest;
import com.simportal.model.Address;
import com.simportal.model.Customer;
import com.simportal.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;

    public boolean validateEmailAndDob(String email, java.time.LocalDate dob) {
        return repo.existsByEmailAndDateOfBirth(email, dob);
    }

    public Optional<Customer> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public Customer register(CustomerRegisterRequest req) {
        Customer c = new Customer();
        c.setFirstName(req.getFirstName());
        c.setLastName(req.getLastName());
        c.setEmail(req.getEmail());
        c.setDateOfBirth(req.getDateOfBirth());

        Address a = new Address();
        a.setStreet(req.getStreet());
        a.setCity(req.getCity());
        a.setState(req.getState());
        a.setZipCode(req.getZipCode());
        c.setAddress(a);

        return repo.save(c);
    }
}