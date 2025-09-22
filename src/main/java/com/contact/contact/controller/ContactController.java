package com.contact.contact.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.contact.entity.Contact;
import com.contact.contact.service.ContactService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "${frontend.url}")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping
    public Page<Contact> getAllContacts(Pageable pageable) {
        return service.getAllContacts(pageable);
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

}