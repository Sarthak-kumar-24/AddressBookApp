## UC23 – Add Multiple Contacts to JSON Server and Sync with Application Memory

### Objective
Implement the ability to add multiple contacts to a JSON Server using REST API calls and synchronize the Address Book application memory with the server data.

### Description
In this use case, the Address Book application sends multiple HTTP POST requests to a JSON Server to create new contact entries. REST Assured is used within JUnit test cases to interact with the REST APIs. After successfully adding contacts to the JSON Server, the Address Book application memory is updated to keep the local data synchronized with the server.

### Features Implemented
- Add multiple contacts to JSON Server using REST API calls.
- Use REST Assured for sending HTTP POST requests.
- Verify successful insertion of contacts on the JSON Server.
- Synchronize the Address Book application memory with the server data.

### Technologies Used
- Java
- Spring Boot
- REST Assured
- JSON Server
- JUnit
- Maven

### Outcome
The Address Book application successfully adds multiple contacts to the JSON Server and synchronizes the application memory with the updated server data.
