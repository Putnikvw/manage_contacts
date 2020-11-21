package com.example.service.impl;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
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
