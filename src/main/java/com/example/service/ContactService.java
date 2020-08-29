package com.example.service;

import com.example.entity.Contact;

import java.util.List;

public interface ContactService {

    Contact addContact(Contact contact);

    List<Contact> getAll();

    List<Contact> findByPostCode(String postCode);


}
