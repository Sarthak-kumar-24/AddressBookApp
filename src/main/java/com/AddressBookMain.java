package com;

import java.util.Scanner;

import com.book.AddressBook;
import com.book.Contact;

/**
 * AddressBookMain is the entry point of the Address Book application.
 *
 * Uses a switch-case menu to perform operations:
 * UC1 : Display welcome message
 * UC2 : Add a contact
 * UC3 : Edit an existing contact
 * UC4 : Delete a contact
 * UC5 : Add multiple contacts using Collection
 */
public class AddressBookMain {

    /**
     * Main method where program execution begins.
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contact");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                	// UC5: Add multiple contacts (one at a time)
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

                    Contact contact = new Contact(
                            firstName, lastName, address, city, state, zip, phoneNumber, email
                    );

                    addressBook.addContact(contact);
                    break;

                case 2:
                    // UC3: Edit contact
                    System.out.print("Enter First Name to edit contact: ");
                    String editName = scanner.nextLine();
                    addressBook.editContactByName(editName);
                    break;

                case 3:
                    // UC4: Delete contact
                    System.out.print("Enter First Name to delete contact: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContactByName(deleteName);
                    break;

                case 4:
                    // Display contact
                    addressBook.displayContacts();
                    break;

                case 0:
                    System.out.println("Exiting Address Book Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}