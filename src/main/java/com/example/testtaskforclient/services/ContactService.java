package com.example.testtaskforclient.services;

import com.example.testtaskforclient.entitys.Contact;
import com.example.testtaskforclient.entitys.enumirated.ContactType;

public interface ContactService {

    Contact createdContact(Long clientId, String value, ContactType type);

}
