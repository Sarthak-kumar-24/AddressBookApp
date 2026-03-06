package com.addressbook.service;

import static io.restassured.RestAssured.get;

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

}
