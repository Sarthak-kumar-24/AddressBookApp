package com.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addressbook.entity.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
	
	/*
	 * save(AddressBook addressBook)
	 * findAll()
	 * findById(Long id)
	 * deleteById(Long id)
	 * count()
	 * existsById(Long id)
	 * 
	 */
}
