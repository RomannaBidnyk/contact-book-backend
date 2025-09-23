package com.contact.contact.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.contact.entity.Contact;
import com.contact.contact.service.ContactService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping
    public Page<Contact> getAllContacts(Pageable pageable) {
        return service.getAllContacts(pageable);
    }

    @PostMapping
    public ResponseEntity<?> createContact(@Valid @RequestBody Contact contact) {
        try {
            Contact saved = service.saveContact(contact);
            return ResponseEntity.ok(saved);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already exists");
        }
    }

}