package com;

import java.util.Scanner;

import com.book.AddressBook;
import com.book.Contact;


/**
 * AddressBookMain is the entry point of the Address Book application.
 * 
 * Responsibilities:
 * - Display welcome message (UC1)
 * - Take user input via console
 * - Create Contact object
 * - Invoke AddressBook methods (UC2, UC3)
 */
public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book Program");

		Scanner scanner = new Scanner(System.in);

		AddressBook addressBook = new AddressBook();

		System.out.print("Enter First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter Address: ");
		String address = scanner.nextLine();

		System.out.print("Enter City: ");
		String city = scanner.nextLine();

		System.out.print("Enter State: ");
		String state = scanner.nextLine();

		System.out.print("Enter Zip: ");
		String zip = scanner.nextLine();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = scanner.nextLine();

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

		addressBook.addContact(contact);

		// UC-3: Edit contact
		System.out.print("\nEnter First Name to edit contact: ");
		String editName = scanner.nextLine();

		addressBook.editContactByName(editName);

		System.out.println("\nUpdated Contact:");
		addressBook.displayContact();

		scanner.close();
	}
}