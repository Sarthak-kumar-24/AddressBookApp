## UC25 – Delete Contact from JSON Server and Sync with Application Memory

### Objective
Implement the ability to delete an existing contact from the JSON Server and synchronize the change with the Address Book application memory.

### Description
In this use case, the Address Book application sends an HTTP DELETE request to the JSON Server to remove a specific contact entry. REST Assured is used within JUnit test cases to perform the REST API call and verify the response. After successfully deleting the contact from the JSON Server, the Address Book application memory is updated to keep the local data synchronized with the server.

### Features Implemented
- Delete an existing contact from JSON Server using REST API.
- Send HTTP DELETE requests using REST Assured.
- Verify successful deletion of the contact on the JSON Server.
- Synchronize the Address Book application memory with the updated server data.

### Technologies Used
- Java
- Spring Boot
- REST Assured
- JSON Server
- JUnit
- Maven

### Outcome
The Address Book application successfully deletes contact entries from the JSON Server and maintains synchronization between the server data and the application memory.
