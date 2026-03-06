package com.addressbook.service;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.addressbook.entity.Contact;

import io.restassured.response.Response;

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

}
