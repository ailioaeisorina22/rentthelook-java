# RentTheLook – Spring Boot Backend

Backend application migrated from Node.js to Java Spring Boot as part of the RentTheLook project.

This project focuses on building a scalable and secure RESTful API using modern Java enterprise technologies.  
The application is currently under active development.

## Tech Stack
- Java 17+
- Spring Boot
- Spring Security with JWT authentication
- JPA / Hibernate
- MySQL
- Maven

## Key Features
- RESTful API architecture
- User authentication and authorization using JWT
- Product, order, and rental management
- Role-based access control (admin / user)
- Secure configuration using environment variables

## Configuration
The application uses an `application.properties` file which is excluded from version control.

Local configuration file:
src/main/resources/application.properties

Example properties:
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
jwt.secret=

## Running the Application
mvn spring-boot:run

The API will be available at:
http://localhost:8080

## Build
mvn clean package

## Project Status
Work in progress – ongoing development and improvements.
