package com.contact.contact.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.contact.contact.entity.Contact;
import com.contact.contact.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public Page<Contact> getAllContacts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public void deleteContact(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Contact not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
