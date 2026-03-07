package com.addressbook.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Contact class represents a single person in the Address Book.
 * 
 * It stores personal details such as name, address, city, state, zip, phone
 * number, and email.
 * 
 * This class is used across multiple use cases (UC1, UC2, UC3) as the core data
 * model.
 * UC7: Overrides equals() to prevent duplicate entries.
 */

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "id")
public class Contact {

	/**
     * Primary Key for database table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;
	
	 private LocalDate dateAdded; // UC18 specific
	
	@ManyToOne
	@JoinColumn(name = "address_book_id")
	private AddressBook addressBook;
	

	/**
	 * Displays all contact details in a readable format. Used after adding or
	 * editing a contact.
	 */
	public void displayContact() {
		System.out.println("----- Contact Details -----");
		System.out.println("Name        : " + firstName + " " + lastName);
		System.out.println("Address     : " + address);
		System.out.println("City        : " + city);
		System.out.println("State       : " + state);
		System.out.println("Zip         : " + zip);
		System.out.println("Phone No.   : " + phoneNumber);
		System.out.println("Email       : " + email);
	}

}
