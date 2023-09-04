package com.example.testtaskforclient.controllers;

import com.example.testtaskforclient.entitys.Client;
import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;
import com.example.testtaskforclient.services.ClientService;
import com.example.testtaskforclient.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ClientService clientService;

    public ContactController(ContactService contactService, ClientService clientService) {
        this.contactService = contactService;
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(
            @RequestParam Long clientId,
            @RequestParam String value,
            @RequestParam ContactType type) {
        Client client = clientService.getClientById(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        Contact contact = contactService.createdContact(clientId, value, type);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable Long clientId) {
        List<Contact> contacts = clientService.getClientContacts(clientId);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/client/{clientId}/type/{type}")
    public ResponseEntity<List<Contact>> getClientContactsByType(
            @PathVariable Long clientId,
            @PathVariable ContactType type) {
        List<Contact> contacts = clientService.getClientContactsByType(clientId, type);
        return ResponseEntity.ok(contacts);
    }
}
