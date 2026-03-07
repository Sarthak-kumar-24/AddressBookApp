package com.addressbook.util;


import java.io.*;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.entity.Contact;

/**
 * AddressBookFileIO handles file read and write operations.
 * 
 * UC13: Read and Write Address Book using Java File IO.
 */
@Service
public class AddressBookFileIO {

    /**
     * Writes contact list to a file in CSV format.
     */
    public void writeToFile(String fileName, List<Contact> contactList) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Contact contact : contactList) {

                writer.write(
                        contact.getFirstName() + "," +
                        contact.getLastName() + "," +
                        contact.getAddress() + "," +
                        contact.getCity() + "," +
                        contact.getState() + "," +
                        contact.getZip() + "," +
                        contact.getPhoneNumber() + "," +
                        contact.getEmail()
                );

                writer.newLine();
            }

            System.out.println("Contacts written to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    /**
     * Reads contacts from file and returns list of Contact objects.
     */
    public void readFromFile(String fileName, List<Contact> contactList) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 8) {

                	// .builder() because in entity class we use @Builder 
					Contact contact = Contact.builder()
					        .firstName(data[0])
					        .lastName(data[1])
					        .address(data[2])
					        .city(data[3])
					        .state(data[4])
					        .zip(data[5])
					        .phoneNumber(data[6])
					        .email(data[7])
					        .build();

                    contactList.add(contact);
                }
            }

            System.out.println("Contacts loaded from file successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}