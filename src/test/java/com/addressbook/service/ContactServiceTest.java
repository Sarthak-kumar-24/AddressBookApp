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
     * UC16
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
     * UC16
     * Test count by state
     */
    @Test
    public void testCountByState() {

        Long count = contactService.countByState("MP");

        assertNotNull(count);

        System.out.println("Contacts in MP: " + count);
    }
    
    // UC17
    @Test
    public void testUpdateContactAndCheckSyncWithDB() {

        // Step 1: create contact
        Contact contact = new Contact();
        contact.setFirstName("Test");
        contact.setLastName("User");
        contact.setCity("Bhopal");
        contact.setState("MP");
        contact.setZip("462001");
        contact.setPhoneNumber("9999999999");
        contact.setEmail("test@gmail.com");

        Contact savedContact = contactService.addContact(contact);

        // Step 2: update memory object
        savedContact.setCity("Indore");

        contactService.updateContact(savedContact.getId(), savedContact);

        // Step 3: fetch from DB
        Contact contactFromDB = contactService.getContactById(savedContact.getId());

        // Step 4: compare memory vs DB
        assertEquals(savedContact, contactFromDB);

        System.out.println("Contact is synced with DB successfully");
    }
    
    
    // UC19
    @Test
    public void testCountContactsByCityDB() {

        int count = contactService.countContactsByCityDB("Bhopal");

        assertTrue(count >= 0);

        System.out.println("Contacts in Bhopal: " + count);
    }
    
    // UC19
    @Test
    public void testCountContactsByStateDB() {

        int count = contactService.countContactsByStateDB("MP");

        assertTrue(count >= 0);

        System.out.println("Contacts in MP: " + count);
    }
}