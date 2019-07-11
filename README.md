kataBank
What's inside
This project is based on the Spring Boot project and uses these packages :

Maven
Spring Core
Spring Data (Hibernate & MySQL)
Spring MVC (Tomcat)
Thymleaf
Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

Database configuration
Create a MySQL database with the name springbootdb and add the credentials to /resources/application.properties.
The default ones are :

spring.datasource.url=jdbc:mysql://localhost:3306/kataBank
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
Usage
Run the project through the IDE and head out to http://localhost:8080

or

run this command in the command line:

mvn spring-boot:run
