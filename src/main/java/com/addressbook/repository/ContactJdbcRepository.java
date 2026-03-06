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
    
    
    /**
     * UC19
     * Count contacts using DB function by city
     * 
     * 
     * queryForObject() is used when the SQL query returns exactly one value.
     * Integer.class   :  This tells Spring what type the result should be converted into.
     */
    public int countContactsByCity(String city) {

        String sql = "SELECT count_contacts_by_city(?)";

        return jdbcTemplate.queryForObject(sql, Integer.class, city);
    }

    /**
     * UC19
     * Count contacts using DB function by state
     */
    public int countContactsByState(String state) {

        String sql = "SELECT count_contacts_by_state(?)";

        return jdbcTemplate.queryForObject(sql, Integer.class, state);
    }
}
