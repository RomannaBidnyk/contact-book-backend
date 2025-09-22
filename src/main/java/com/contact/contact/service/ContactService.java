package com.contact.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contact.contact.entity.Contact;
import com.contact.contact.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }
}
