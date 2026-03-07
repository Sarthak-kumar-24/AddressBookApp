## UC24 – Update Contact in JSON Server and Sync with Application Memory

### Objective
Implement the ability to update an existing contact in the JSON Server and synchronize the changes with the Address Book application memory.

### Description
In this use case, the Address Book application sends an HTTP PUT request to the JSON Server to update the details of an existing contact. REST Assured is used within JUnit test cases to perform the REST API call and verify the response. After successfully updating the contact on the JSON Server, the application memory is updated to maintain synchronization with the server data.

### Features Implemented
- Update an existing contact entry in JSON Server using REST API.
- Send HTTP PUT requests using REST Assured.
- Verify the successful update of contact data on the JSON Server.
- Synchronize the updated contact information with the Address Book application memory.

### Technologies Used
- Java
- Spring Boot
- REST Assured
- JSON Server
- JUnit
- Maven

### Outcome
The Address Book application successfully updates contact details on the JSON Server and keeps the application memory synchronized with the updated server data.
