package com.example.repository;

import com.example.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c where c.address.postCode = :postCode")
    List<Contact> findByPostCode(@Param("postCode") String postCode);


}
