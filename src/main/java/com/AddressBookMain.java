package com;

import java.util.Scanner;

import com.book.AddressBook;
import com.book.Contact;

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

		System.out.println("\nContacts in Address Book:");
		addressBook.displayContacts();

		contact.displayContact();

		scanner.close();
	}
}