# BANKING System

This abstract system manages bank accounts with credit cards.
Project was created with the Gradle build framework and its main goal was to become a flexible OOP system with a database connection.
# Used technologies
- Docker
- Postgresql
- Flyway DB migration
- Java 8
- Gradle
- Junit and Mockito

# Description
The main functionalities are creating, storing and retrieving account information.

Creating account is connected with creating a proper card number with the Luhn's algorithm and a random PIN.

Thanks to a great impact on the system flexibility and usage of interfaces, storing method is easy to modify.
Actual, there are 2 methods: testing fake data source and a real postgres implementation.

A postgresql data source was conected and checked with a real instance which was running on a docker container.
What is more, I used A flyway database migration tool in order to maintain a versioning of a DB easily.

In order to modify and retrieve information, Java classes use the JDBC drivers and API. 
At the same time, this solution doesn't satisfy me and I  think I would like to try to use a Spring framework in the future.

Currently user is able to create a new account and login into it with given credentials.


# Possible upgrades
- Upgrading functionalities
- Better system security
- Use of a Spring and its benefits like a dependency injection and DB API
  
