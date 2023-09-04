package com.example.testtaskforclient.services.impl;

import com.example.testtaskforclient.entitys.Client;
import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;
import com.example.testtaskforclient.repository.ClientRepository;
import com.example.testtaskforclient.repository.ContactRepository;
import com.example.testtaskforclient.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiseImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    public ClientServiseImpl(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Client createClient(String name) {
        Client client = new Client();
        client.setName(name);
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void addContactToClient(Long clientid, String value, ContactType type) {
        Client client = clientRepository.findById(clientid).orElseThrow();

        Contact contact = new Contact();
        contact.setValue(value);
        contact.setType(type);
        contact.setClient(client);

    }

    @Override
    public List<Contact> getClientContacts(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        return contactRepository.findByClient(client);
    }

    @Override
    public List<Contact> getClientContactsByType(Long clientId, ContactType type) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        return contactRepository.findByClientAndType(client,type);

    }
}
