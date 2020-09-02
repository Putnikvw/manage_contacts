package com.example.controller;

import com.example.entity.Contact;
import com.example.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    private static final Logger LOGGER = LogManager.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> getAll(String postCode) {
        if (postCode != null)
            return contactService.findByPostCode(postCode);
        else
            return contactService.getAll();
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact addContact(@RequestBody Contact contact) {
        LOGGER.info("Start add a new contact");

        return contactService.addContact(contact);
    }
}
