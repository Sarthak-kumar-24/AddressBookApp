package com.addressbook.service;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.addressbook.entity.Contact;

@SpringBootTest
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    /**
     * UC16
     * Test retrieval of all contacts from DB
     */
    @Test
    public void testGetAllContacts() {

        List<Contact> contacts = contactService.getAllContacts();

        assertNotNull(contacts, "Contact list should not be null");

        System.out.println("Total contacts found: " + contacts.size());

        contacts.forEach(contact -> {
            System.out.println(contact);
        });
    }

    /**
     * Test search by city
     */
    @Test
    public void testSearchByCity() {

        List<Contact> contacts = contactService.searchByCity("Bhopal");

        assertNotNull(contacts);

        contacts.forEach(contact ->
            assertEquals("Bhopal", contact.getCity())
        );
    }

    /**
     * Test count by state
     */
    @Test
    public void testCountByState() {

        Long count = contactService.countByState("MP");

        assertNotNull(count);

        System.out.println("Contacts in MP: " + count);
    }
}