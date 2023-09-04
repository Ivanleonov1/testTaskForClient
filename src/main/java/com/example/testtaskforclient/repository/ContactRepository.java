package com.example.testtaskforclient.repository;

import com.example.testtaskforclient.entitys.Client;
import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByClient(Client client);
    List<Contact> findByClientAndType(Client client, ContactType type);

}
