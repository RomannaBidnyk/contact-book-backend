package com.contact.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}