## UC17 – Update Contact in Address Book Database

### Objective
Implement the ability to update an existing contact stored in the Address Book database.

### Description
In this use case, the Address Book application allows modification of an existing contact's information stored in the database. When a contact is updated, the changes are reflected both in the database and in the application memory to maintain data consistency.

### Features Implemented
- Identify a contact in the database using its unique identifier.
- Update contact details such as address, city, state, zip code, phone number, or email.
- Persist the updated information in the database.
- Ensure synchronization between the application memory and the database.

### Technologies Used
- Spring Boot
- Java
- Spring Data JPA
- MySQL Database
- Maven

### Outcome
The Address Book application successfully updates existing contact details in the database while keeping the application memory synchronized with the database records.
