package com.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * AddressBook class manages operations related to Contact.
 *
 * UC2 : Add a contact
 * UC3 : Edit an existing contact
 * UC4 : Delete a contact using person's name
 * UC5 : Add multiple contacts using Collection
 * UC7: Prevents duplicate contact entry using Streams.
 */
public class AddressBook {

	private List<Contact> contactList;

	 public AddressBook() {
	        contactList = new ArrayList<>();
	}
	 
	 
	/**
	 * UC7
	 * Adds contact only if duplicate does NOT exist.
	 */
	public void addContact(Contact newContact) {
	     boolean isDuplicate = contactList.stream()
	                .anyMatch(existingContact -> existingContact.equals(newContact));

	        if (isDuplicate) {
	            System.out.println("Duplicate contact found! Contact not added.");
	            return;
	        }

	        contactList.add(newContact);
	        System.out.println("Contact added successfully!");
	}
	
	
	public List<Contact> getContacts() {
	    return contactList;
	}

	/**
	 * Displays the stored contact details. If no contact exists, displays an
	 * appropriate message.
	 */
    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }

        for (Contact contact : contactList) {
            contact.displayContact();
            System.out.println();
        }
    }

	/**
	 * Edits an existing contact using first name as identifier.
	 * 
	 * UC3 functionality 
	 * - Searches for the contact by name 
	 * - Allows user to update
	 * all fields
	 */
    public void editContactByName(String firstName, Scanner scanner) {

        
        

        for (Contact contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                System.out.println("Editing contact for: " + firstName);

                System.out.print("Enter new Last Name: ");
                contact.setLastName(scanner.nextLine());

                System.out.print("Enter new Address: ");
                contact.setAddress(scanner.nextLine());

                System.out.print("Enter new City: ");
                contact.setCity(scanner.nextLine());

                System.out.print("Enter new State: ");
                contact.setState(scanner.nextLine());

                System.out.print("Enter new Zip: ");
                contact.setZip(scanner.nextLine());

                System.out.print("Enter new Phone Number: ");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter new Email: ");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully!");
                
                return;
                
            }
            
        }
            System.out.println("Contact not found.");
    }

    /**
     * UC4:
     * Deletes a contact using first name.
     */
    public void deleteContactByName(String firstName) {

        Iterator<Contact> iterator = contactList.iterator();
        boolean isFound = false;

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully!");
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Contact not found.");
        }
    }
}