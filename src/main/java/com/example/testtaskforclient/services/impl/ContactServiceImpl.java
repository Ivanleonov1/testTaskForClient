package com.example.testtaskforclient.services.impl;

import com.example.testtaskforclient.entitys.Client;
import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;
import com.example.testtaskforclient.repository.ClientRepository;
import com.example.testtaskforclient.repository.ContactRepository;
import com.example.testtaskforclient.services.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;

    public ContactServiceImpl(ContactRepository contactRepository, ClientRepository clientRepository) {
        this.contactRepository = contactRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Contact createdContact(Long clientId, String value, ContactType type) {
        Client client = clientRepository.findById(clientId).orElseThrow();

        Contact contact = new Contact();
        contact.setValue(value);
        contact.setType(type);
        contact.setClient(client);
        return contactRepository.save(contact);
    }
}
