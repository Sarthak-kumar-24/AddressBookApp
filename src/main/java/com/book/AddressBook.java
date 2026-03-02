package com.book;

import java.util.Scanner;

/**
 * AddressBook class manages operations related to Contact.
 *
 * UC2 : Add a contact
 * UC3 : Edit an existing contact
 * UC4 : Delete a contact using person's name
 */
public class AddressBook {

	private Contact contact;

	/**
	 * Adds a contact to the Address Book. This method is used in UC2.
	 */
	public void addContact(Contact contact) {
		this.contact = contact;
		System.out.println("Contact added successfully!");
	}

	/**
	 * Displays the stored contact details. If no contact exists, displays an
	 * appropriate message.
	 */
	public void displayContact() {
		if (contact == null) {
			System.out.println("No contact available.");
			return;
		}
		contact.displayContact();
	}

	/**
	 * Edits an existing contact using first name as identifier.
	 * 
	 * UC3 functionality 
	 * - Searches for the contact by name 
	 * - Allows user to update
	 * all fields
	 */
	public void editContactByName(String firstName) {

		if (contact == null) {
			System.out.println("No contact to edit.");
			return;
		}

		if (!contact.getFirstName().equalsIgnoreCase(firstName)) {
			System.out.println("Contact not found.");
			return;
		}

		Scanner scanner = new Scanner(System.in);

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
		
		scanner.close();

		System.out.println("Contact updated successfully!");
	}
	
	  /**
     * UC4: Deletes an existing contact using first name.
     *
     * If the name matches, the contact is removed
     * by setting reference to null.
     */
    public void deleteContactByName(String firstName) {

        if (contact == null) {
            System.out.println("No contact to delete.");
            return;
        }

        if (contact.getFirstName().equalsIgnoreCase(firstName)) {
            contact = null;
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}