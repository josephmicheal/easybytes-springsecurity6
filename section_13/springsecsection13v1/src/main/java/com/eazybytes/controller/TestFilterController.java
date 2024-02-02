package com.eazybytes.controller;

import com.eazybytes.model.Contact;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestFilterController {

    @PreFilter("filterObject.contactName != 'Test'")
    @PostFilter("filterObject.contactName != 'Private'")
    @GetMapping("/filterContacts")
    public List<Contact> processContacts(List<Contact> contacts) {
        return contacts;
    }

}
