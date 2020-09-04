package com.example.util;


import com.example.entity.Address;
import com.example.entity.Contact;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestDataGenerator {

    public Contact generateContact() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        Contact contact = new Contact();
        contact.setFullName(person.getFullName());
        contact.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthOfYear(),
                person.getDateOfBirth().getDayOfMonth()));

        Address address = new Address();
        address.setCity(person.getAddress().getCity());
        address.setPostCode(person.getAddress().getPostalCode());
        contact.setAddress(address);

        return contact;
    }

    public List<Contact> generateContactList(int size){
        return Stream.generate(this::generateContact)
                .limit(size)
                .collect(toList());
    }
}