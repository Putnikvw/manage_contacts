package com.example.config;

import com.example.repository.ContactRepository;
import com.example.util.TestDataGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataGeneratorConfig implements InitializingBean {

    @Autowired
    private ContactRepository contactRepository;

    @Bean
    public TestDataGenerator dataGenerator() {
        return new TestDataGenerator();
    }


    @Override
    public void afterPropertiesSet() {
        contactRepository.saveAll(dataGenerator().generateContactList(10));
    }
}
