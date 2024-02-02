package com.eazybytes.controller;

import com.eazybytes.model.Cards;
import com.eazybytes.model.Customer;
import com.eazybytes.repository.CardsRepository;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myCards")
    @PostFilter("filterObject.cardNumber != '3455XXXX8673'")
    public List<Cards> getCardDetails(@RequestParam String email) {

        List<Customer> customerList =  customerRepository.findByEmail(email);
        if(customerList!= null && !customerList.isEmpty()) {
            List<Cards> cards = cardsRepository.findByCustomerId(customerList.get(0).getId());
            if (cards != null) {
                return cards;
            }
        }
        return null;

    }
}
