package com.addressbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "address_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contacts")
public class AddressBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;


}