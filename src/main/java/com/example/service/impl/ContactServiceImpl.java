package com.example.service.impl;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
        if(contact.getKey() == null) {
            contact.setKey(UUID.randomUUID().toString());
        }

        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public List<Contact> getAll() {

        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findByPostCode(String postCode) {

        return contactRepository.findAllByAddress_PostCode(postCode);
    }
}
