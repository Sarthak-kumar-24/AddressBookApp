package com.addressbook.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.entity.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * UC14: Handles CSV read/write using OpenCSV library.
 */
@Service
public class AddressBookCSVService {

	/**
	 * Write contacts to CSV file using OpenCSV.
	 */
	public void writeToCSV(String fileName, List<Contact> contactList) {

		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

			for (Contact contact : contactList) {

				String[] data = { 
						contact.getFirstName(), 
						contact.getLastName(), 
						contact.getAddress(),
						contact.getCity(), 
						contact.getState(), 
						contact.getZip(), 
						contact.getPhoneNumber(),
						contact.getEmail() 
						};

				writer.writeNext(data);
			}

			System.out.println("Contacts written to CSV successfully!");

		} catch (IOException e) {
			System.out.println("Error writing CSV: " + e.getMessage());
		}
	}

	/**
	 * Read contacts from CSV file using OpenCSV.
	 */
	public void readFromCSV(String fileName, List<Contact> contactList) {

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

			List<String[]> records = reader.readAll();

			for (String[] data : records) {

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

			System.out.println("Contacts loaded from CSV successfully!");

		} catch (Exception e) {
			System.out.println("Error reading CSV: " + e.getMessage());
		}
	}
}
