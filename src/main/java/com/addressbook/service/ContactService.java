package com.addressbook.service;



import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressbook.entity.Contact;
import com.addressbook.repository.ContactJdbcRepository;
import com.addressbook.repository.ContactRepository;

/**
 * ContactService contains the business logic of the Address Book system.
 *
 * It connects Controller with Repository and implements the operations
 * required by different Use Cases.
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private ContactJdbcRepository contactJdbcRepository;

    /**
     * UC2
     * Add new contact
     */
    public Contact addContact(Contact contact) {

        if(contactRepository.existsByEmail(contact.getEmail())) {
            throw new RuntimeException("Contact with this email already exists");
        }

        return contactRepository.save(contact);
    }

    /**
     * Display all contacts
     */
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    
    public Contact getContactById(Long id) {

        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    /**
     * UC3
     * Edit existing contact
     */
    public Contact updateContact(Long id, Contact updatedContact) {

    	Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        existingContact.setFirstName(updatedContact.getFirstName());
        existingContact.setLastName(updatedContact.getLastName());
        existingContact.setCity(updatedContact.getCity());
        existingContact.setState(updatedContact.getState());
        existingContact.setZip(updatedContact.getZip());
        existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setAddress(updatedContact.getAddress());

        return contactRepository.save(existingContact);
    }

    /**
     * UC4
     * Delete contact by ID
     */
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    /**
     * UC8
     * Search contacts by city
     */
    public List<Contact> searchByCity(String city) {
        return contactRepository.findByCityIgnoreCase(city);
    }

    /**
     * UC8
     * Search contacts by state
     */
    public List<Contact> searchByState(String state) {
        return contactRepository.findByStateIgnoreCase(state);
    }

    /**
     * UC10
     * Count contacts by city
     */
    public long countByCity(String city) {
        return contactRepository.countByCityIgnoreCase(city);
    }

    /**
     * UC10
     * Count contacts by state
     */
    public long countByState(String state) {
        return contactRepository.countByStateIgnoreCase(state);
    }

    /**
     * UC11
     * Sort contacts alphabetically by name
     */
    public List<Contact> sortByName() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator
                .comparing(Contact::getFirstName)
                .thenComparing(Contact::getLastName));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by city
     */
    public List<Contact> sortByCity() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getCity));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by state
     */
    public List<Contact> sortByState() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getState));

        return contacts;
    }

    /**
     * UC12
     * Sort contacts by zip
     */
    public List<Contact> sortByZip() {

        List<Contact> contacts = contactRepository.findAll();

        contacts.sort(Comparator.comparing(Contact::getZip));

        return contacts;
    }
    
    
    /**
     * UC18
     * Retrieve contacts added between two dates
     */
    public List<Contact> getContactsAddedBetween(LocalDate start, LocalDate end) {

        return contactJdbcRepository.findContactsAddedBetween(start, end);
    }
    
    
    /**
     * UC19
     * Count contacts by city using DB function
     */
    public int countContactsByCityDB(String city) {
        return contactJdbcRepository.countContactsByCity(city);
    }

    /**
     * UC19
     * Count contacts by state using DB function
     */
    public int countContactsByStateDB(String state) {
        return contactJdbcRepository.countContactsByState(state);
    }
    
    
    /**
     * UC20
     * Add contact using JDBC with transaction
     */
    @Transactional
    public void addContactUsingJDBC(Contact contact) {

        int rows = contactJdbcRepository.addContact(contact);

        if(rows == 0) {
            throw new RuntimeException("Contact insertion failed");
        }
    }
}