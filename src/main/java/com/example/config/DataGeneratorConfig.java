package com.example.config;

import com.example.repository.ContactRepository;
import com.example.util.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataGeneratorConfig {

    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    public void dataGenerator() {
        contactRepository.saveAll(new TestDataGenerator().generateContactList(10));
    }
}
