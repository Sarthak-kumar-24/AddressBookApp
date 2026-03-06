package com.addressbook.repository;



import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.addressbook.entity.Contact;

//This directly uses JDBC instead of JPA.
@Repository
public class ContactJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
	public List<Contact> findContactsAddedBetween(LocalDate start, LocalDate end) {

        String sql = "SELECT * FROM contacts WHERE date_added BETWEEN ? AND ?";

        return jdbcTemplate.query(
                sql,
                new Object[]{Date.valueOf(start), Date.valueOf(end)},
                (rs, rowNum) -> {

                    Contact contact = new Contact();

                    contact.setFirstName(rs.getString("first_name"));
                    contact.setLastName(rs.getString("last_name"));
                    contact.setCity(rs.getString("city"));
                    contact.setState(rs.getString("state"));
                    contact.setZip(rs.getString("zip"));
                    contact.setPhoneNumber(rs.getString("phone_number"));
                    contact.setEmail(rs.getString("email"));
                    contact.setAddress(rs.getString("address"));

                    return contact;
                }
        );
    }
}
