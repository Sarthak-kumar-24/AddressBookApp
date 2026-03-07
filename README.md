## UC18 – Retrieve Contacts Added in a Particular Date Range

### Objective
Implement the ability to retrieve contacts from the database that were added within a specific time period.

### Description
In this use case, the Address Book application retrieves contacts that were added during a particular date range. A new field is maintained in the database to record when each contact is added. The application queries the database and returns contacts that fall within the specified date interval.

### Features Implemented
- Add a `date_added` field in the contacts table to track when a contact is created.
- Retrieve contacts added within a specified date range.
- Use JDBC to perform database operations.
- Display the contacts that match the given date criteria.

### Technologies Used
- Spring Boot
- Java
- JDBC
- MySQL Database
- Maven

### Outcome
The Address Book application successfully retrieves contacts from the database that were added during a specified time period, enabling time-based filtering of contact records.
