package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.book.AddressBook;
import com.book.AddressBookCSVService;
import com.book.AddressBookFileIO;
import com.book.AddressBookJSONService;
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
 * UC6 : Add multiple Address Books with unique name
 */
public class AddressBookMain {

    /**
     * Main method where program execution begins.
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);

        // UC6: Dictionary to store AddressBookName -> AddressBook
        Map<String, AddressBook> addressBookMap = new HashMap<>();
        AddressBookFileIO fileService = new AddressBookFileIO();
        AddressBookCSVService csvService = new AddressBookCSVService();
        AddressBookJSONService jsonService = new AddressBookJSONService();
        
        AddressBook currentAddressBook = null;
        int choice;

        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Add Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Display Contacts");
            System.out.println("7. Search Person by City");
            System.out.println("8. Search Person by State");
            System.out.println("9. View Persons by City");
            System.out.println("10. View Persons by State");
            System.out.println("11. Count Contacts by City");
            System.out.println("12. Count Contacts by State");
            System.out.println("13. Sort Contacts by Name");
            System.out.println("14. Sort Contacts by City");
            System.out.println("15. Sort Contacts by State");
            System.out.println("16. Sort Contacts by Zip");
            System.out.println("17. Write Contacts to File");
            System.out.println("18. Read Contacts from File");
            System.out.println("19. Write Contacts to CSV");
            System.out.println("20. Read Contacts from CSV");
            System.out.println("21. Write Contacts to JSON");
            System.out.println("22. Read Contacts from JSON");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

            case 1:
                // Create new Address Book
                System.out.print("Enter Address Book Name: ");
                String bookName = scanner.nextLine();

                if (addressBookMap.containsKey(bookName)) {
                    System.out.println("Address Book already exists!");
                } else {
                    addressBookMap.put(bookName, new AddressBook());
                    System.out.println("Address Book created successfully!");
                }
                break;

            case 2:
                // Select Address Book
                System.out.print("Enter Address Book Name to select: ");
                String selectName = scanner.nextLine();

                if (addressBookMap.containsKey(selectName)) {
                    currentAddressBook = addressBookMap.get(selectName);
                    System.out.println("Address Book selected: " + selectName);
                } else {
                    System.out.println("Address Book not found!");
                }
                break;

            case 3:
                // Add contact
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

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
                String phone = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                currentAddressBook.addContact(
                        new Contact(firstName, lastName, address,
                                city, state, zip, phone, email)
                );
                break;

            case 4:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                System.out.print("Enter First Name to edit: ");
                currentAddressBook.editContactByName(scanner.nextLine(), scanner);
                break;

            case 5:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                System.out.print("Enter First Name to delete: ");
                currentAddressBook.deleteContactByName(scanner.nextLine());
                break;

            case 6:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.displayContacts();
                break;
                
            case 7:
                System.out.print("Enter City to search: ");
                String searchCity = scanner.nextLine();

                addressBookMap.values().stream()              
                    .flatMap(book -> book.getContacts().stream()) 
                    .filter(contact -> contact.getCity()
                        .equalsIgnoreCase(searchCity))
                    .forEach(contact -> {
                        contact.displayContact();
                        System.out.println();
                    });
                break;
                
            case 8:
                System.out.print("Enter State to search: ");
                String searchState = scanner.nextLine();

                addressBookMap.values().stream()
                    .flatMap(book -> book.getContacts().stream())
                    .filter(contact -> contact.getState().equalsIgnoreCase(searchState))
                    .forEach(contact -> {
                        contact.displayContact();
                        System.out.println();
                    });
                break;

            case 9:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter City: ");
                currentAddressBook.viewPersonsByCity(scanner.nextLine());
                break;
                
            case 10:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter State: ");
                currentAddressBook.viewPersonsByState(scanner.nextLine());
                break;
            case 11:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.countByCity();
                break;
            case 12:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.countByState();
                break;
            case 13:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.sortContactsByName();
                break;
            case 14:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.sortContactsByCity();
                break;
            case 15:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.sortContactsByState();
                break;
            case 16:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                currentAddressBook.sortContactsByZip();
                break;
            case 17:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                System.out.print("Enter file name: ");
                fileService.writeToFile(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 18:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }
                System.out.print("Enter file name: ");
                fileService.readFromFile(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 19:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter CSV file name (example: contacts.csv): ");
                csvService.writeToCSV(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 20:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter CSV file name to read: ");
                csvService.readFromCSV(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 21:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter JSON file name (example: contacts.json): ");
                jsonService.writeToJSON(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 22:
                if (currentAddressBook == null) {
                    System.out.println("Select an Address Book first!");
                    break;
                }

                System.out.print("Enter JSON file name to read: ");
                jsonService.readFromJSON(scanner.nextLine(), currentAddressBook.getContacts());
                break;
            case 0:
                System.out.println("Exiting Address Book System...");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 0);

    scanner.close();
    }
}