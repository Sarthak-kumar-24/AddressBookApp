package com.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * AddressBook class manages operations related to Contact.
 *
 * UC2 : Add a contact
 * UC3 : Edit an existing contact
 * UC4 : Delete a contact using person's name
 * UC5 : Add multiple contacts using Collection
 * UC7: Prevents duplicate contact entry using Streams.
 * UC10 : Counts number of contacts grouped by city.
 * UC11 : Sort names alphabetically
 * UC12 : Sort by City, OR State, OR Zip
 */
public class AddressBook {

	private List<Contact> contactList;
	private Map<String, List<Contact>> cityMap;
	private Map<String, List<Contact>> stateMap;

	 public AddressBook() {
	        contactList = new ArrayList<>();
	        cityMap = new HashMap<>();
	        stateMap = new HashMap<>();
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
	        // UC9: Add to City Map
	        cityMap.computeIfAbsent(newContact.getCity(), k -> new ArrayList<>())
	                .add(newContact);

	        // UC9: Add to State Map
	        stateMap.computeIfAbsent(newContact.getState(), k -> new ArrayList<>())
	                .add(newContact);
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
    
    public void viewPersonsByCity(String city) {

        List<Contact> persons = cityMap.get(city);

        if (persons == null || persons.isEmpty()) {
            System.out.println("No persons found in city: " + city);
            return;
        }

        persons.forEach(contact -> {
            contact.displayContact();
            System.out.println();
        });
    }
    public void viewPersonsByState(String state) {

        List<Contact> persons = stateMap.get(state);

        if (persons == null || persons.isEmpty()) {
            System.out.println("No persons found in state: " + state);
            return;
        }

        persons.forEach(contact -> {
            contact.displayContact();
            System.out.println();
        });
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
    public void countByCity() {

        Map<String, Long> cityCountMap = contactList.stream()
                .collect(Collectors.groupingBy(
                        Contact::getCity,
                        Collectors.counting()
                ));

        cityCountMap.forEach((city, count) ->
                System.out.println("City: " + city + " | Count: " + count));
    }
    public void countByState() {

        Map<String, Long> stateCountMap = contactList.stream()
                .collect(Collectors.groupingBy(
                        Contact::getState,
                        Collectors.counting()
                ));

        stateCountMap.forEach((state, count) ->
                System.out.println("State: " + state + " | Count: " + count));
    }
    
    
    public void sortContactsByName() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getFirstName)
                        .thenComparing(Contact::getLastName))
                .forEach(System.out::println);
    }
    public void sortContactsByCity() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getCity)
                        .thenComparing(Contact::getFirstName))
                .forEach(System.out::println);
    }
    
    public void sortContactsByState() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getState)
                        .thenComparing(Contact::getFirstName))
                .forEach(System.out::println);
    }
    
    public void sortContactsByZip() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .forEach(System.out::println);
    }
}