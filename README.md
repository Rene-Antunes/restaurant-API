<h1>✅ Project Status</h1>

> :construction: API Rest build with Java/Spring restaurant-API :construction:

<h2 id="sobre" >Project description</h2>
An API for restaurant management aimed at providing small to large-scale entrepreneurs with better business administration. Built with Java and Spring Boot, this API leverages Spring MVC and join SOLID principles and Clean Code practices.


Achievements:

- Successfully implemented employee registration with hierarchical levels
- Developed a robust table scheduling system
- Created a seamless order placement process
- Implemented comprehensive management and registration of payment methods
- Designed and integrated product management and registration features
- Enabled customers to place orders directly from the app without needing to call a waiter
- Ensured reserved tables are marked as unavailable on the specific days they are booked

This project not only showcases my proficiency in Java and the Spring Framework, including Spring Boot and Spring MVC, but also my ability to create practical and efficient solutions for complex business needs.
Competências: JPA (Java Persistence API) · Spring Boot · Spring MVC · Java · API REST

summary:
=================

   * [About](#sobre)
   * [Features](#features)
   * [How to use](#comoUsar)
      * [prerequisites and technologies](#requisitos)
      * [Running the Api](#rodandoApi)
   * [Tests](#testes)

<h2 id="comoUsar">⚙️How to use</h2>

<h2 id="requisitos">✅ prerequisites and technologies </h2>

- [Java](https://www.java.com/pt-BR/download/manual.jsp)
- [Spring Boot](https://spring.io/projects/spring-boot)
- Maven
- IDE [Intellij](https://www.jetbrains.com/idea/download/?section=windows) or [Eclipse](https://www.eclipse.org/downloads/)
- [MySQL](https://www.mysql.com/downloads/)
- [Postman](https://www.postman.com)
- [lombok](https://projectlombok.org/download)



<h2 id="rodandoApi">🎲 Runing the Api </h2>

<h3> Clone this repository</h3>

git clone <https://github.com/Rene-Antunes/restaraunt-API.git>

<h3>Configurate database</h3>
You must have MySQL installed on your machine. After installation, create a database named <strong>restaurant</strong>. You can update the username and password in the <strong>application.properties</strong> file for your database data.

<h3>Start the application</h3>
Start through the IDE by starting the RestauranteApiApplication.java class.

Through the terminal:
```
java -jar target/restaurant-api.jar
```
```
spring.datasource.username=root
spring.datasource.password=12345678
```
or using maven

```
mvn spring-boot:run
```
**The application will start on port http://localhost:8080**
