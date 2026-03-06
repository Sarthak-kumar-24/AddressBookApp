package com.addressbook.service;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.addressbook.entity.Contact;

import io.restassured.response.Response;

/**
 * 
 * UC22 -> GET contacts from JSONServer
 * UC23 -> POST contacts to JSONServer
 * UC24 -> UPDATE contacts in JSONServer
 * 
 * 
 */
public class AddressBookJSONServerTest {
	@Test
	public void givenContactsInJSONServer_whenRetrieved_shouldUpdateAddressBook() {

		Response response = get("http://localhost:3000/contacts");

		response.then().statusCode(200);

		List<Contact> contacts = response.jsonPath().getList("", Contact.class);

		System.out.println("Contacts retrieved: " + contacts.size());

		contacts.forEach(contact -> System.out.println(contact.getFirstName()));
	}

	@Test
	public void givenMultipleContacts_whenAdded_shouldSyncWithJSONServer() {

		Contact contact1 = new Contact("Aman", "Singh", "Delhi", "Delhi", "DL", "110001", "9999991111",
				"aman@test.com");

		Contact contact2 = new Contact("Rohit", "Verma", "Indore", "Indore", "MP", "452001", "9999992222",
				"rohit@test.com");

		List<Contact> contacts = List.of(contact1, contact2);

		contacts.forEach(contact -> {

			Response response =
			        given()
			                .contentType("application/json")
			                .body(contact)
			        .when()
			                .post("http://localhost:3000/contacts");

			response.then().statusCode(201);

			System.out.println("Added contact: " + contact.getFirstName());
		});
	}

	@Test
	public void whenContactsRetrieved_shouldMatchJSONServerCount() {

		Response response = get("http://localhost:3000/contacts");

		response.then().statusCode(200);

		List<Contact> contacts = response.jsonPath().getList("", Contact.class);

		System.out.println("Total contacts in JSONServer: " + contacts.size());

		contacts.forEach(c -> System.out.println(c.getFirstName()));
	}

	/*
	 * UC24
	 * UPDATE contacts
	 */
	@Test
	public void givenContact_whenUpdated_shouldSyncWithJSONServer() {

	    Contact contact = new Contact(
	            "Sarthak",
	            "Rathore",
	            "Arera Colony",
	            "Bhopal",
	            "MP",
	            "462016",
	            "9999999999",
	            "sarthak@gmail.com"
	    );

	    int contactId = 1;

	    Response response =
	            given()
	                    .contentType("application/json")
	                    .body(contact)
	            .when()
	                    .put("http://localhost:3000/contacts/" + contactId);

	    response.then().statusCode(200);

	    System.out.println("Contact updated successfully");
	}
	
	
	/*
	 * UC24
	 * method to confirm data was updated.
	 */
	@Test
	public void whenContactRetrieved_shouldReflectUpdatedData() {

	    Response response =
	            get("http://localhost:3000/contacts/1");

	    response.then().statusCode(200);

	    Contact contact =
	            response.as(Contact.class);

	    System.out.println("Updated Contact: " + contact.getFirstName());
	}
}
