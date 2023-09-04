package com.example.testtaskforclient.services;

import com.example.testtaskforclient.entitys.Client;
import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;

import java.util.List;

public interface ClientService {

    Client createClient(String name);
    List<Client> getAllClients();
    Client getClientById(Long id);
    void addContactToClient(Long clientid, String value, ContactType type);
    List<Contact> getClientContacts(Long clientId);
    List<Contact> getClientContactsByType(Long clientId, ContactType type);
}
