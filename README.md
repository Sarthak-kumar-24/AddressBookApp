## UC7 – Prevent Duplicate Contacts in Address Book

### Objective
Implement a mechanism to prevent duplicate contacts from being added to the Address Book.

### Description
In this use case, the Address Book application checks whether a contact with the same identifying information already exists before adding a new entry. If a duplicate contact is detected, the application restricts the addition and notifies the user.

### Features Implemented
- Check for existing contacts before adding a new contact.
- Identify duplicates based on key fields such as first name and last name.
- Prevent storing duplicate contact entries in the Address Book.
- Maintain data consistency and integrity.

### Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Collections (ArrayList / HashMap)

### Outcome
The Address Book application successfully ensures that duplicate contacts cannot be added, maintaining a clean and consistent list of contacts.
