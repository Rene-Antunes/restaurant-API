<h1>✅ Status do projeto</h1>

> :construction: API Rest feito em Java com Spring restaurant-API em construção :construction:

<h2 id="sobre" >Descrição do Projeto </h2>
An API for restaurant management aimed at providing small to large-scale entrepreneurs with better business administration. Built with Java and Spring Boot, this API leverages Spring MVC and adheres to SOLID principles and Clean Code practices.


Achievements:

- Successfully implemented employee registration with hierarchical levels
- Developed a robust table scheduling system
- Created a seamless order placement process
- Implemented comprehensive management and registration of payment methods
- Designed and integrated product management and registration features
- Enabled customers to place orders directly from the app without needing to call a waiter
- Ensured reserved tables are marked as unavailable on the specific days they are booked

This project not only showcases my proficiency in Java and the Spring Framework, including Spring Boot and Spring MVC, but also my ability to create practical and efficient solutions for complex business needs.I am currently developing an API for restaurant management aimed at providing small to large-scale entrepreneurs with better business administration. Built with Java and Spring Boot, this API leverages Spring MVC and adheres to SOLID principles and Clean Code practices. Achievements: - Successfully implemented employee registration with hierarchical levels - Developed a robust table scheduling system - Created a seamless order placement process - Implemented comprehensive management and registration of payment methods - Designed and integrated product management and registration features - Enabled customers to place orders directly from the app without needing to call a waiter - Ensured reserved tables are marked as unavailable on the specific days they are booked This project not only showcases my proficiency in Java and the Spring Framework, including Spring Boot and Spring MVC, but also my ability to create practical and efficient solutions for complex business needs.
Competências: JPA (Java Persistence API) · Spring Boot · Spring MVC · Java · API REST

Tabela de conteúdos
=================

   * [Sobre](#sobre)
   * [Features](#features)
   * [Como usar](#comoUsar)
      * [Pré-requisitos e tecnologias](#requisitos)
      * [Rodando a Api](#rodandoApi)
   * [Tests](#testes)
  
<h2 id="features">✅ Features</h2>

- [x] CRUD de usuário
- [x] CRUD  de produtos
- [x] CRUD  de fotos
- [x] CRUD  de mesas
- [x] CRUD  de grupos
- [x] CRUD  de permissões
- [x] CRUD  de formas de pagamento
- [x] Emissão de pedidos
- [x] Agendamento/reserva de mesas
- [x] Associação  e desassociação de permissões a grupos
- [x] Mudança de status de mesas ex: vaga, ocupada
- [x] Mudança de  status de pedido ex: criado, pronto, entregue.



<h2 id="comoUsar">⚙️ Como Usar</h2>

<h2 id="requisitos">✅ Pré-requisitos e tecnologias </h2>

- [Java](https://www.java.com/pt-BR/download/manual.jsp)
- [Spring Boot](https://spring.io/projects/spring-boot)
- Maven
- IDE [Intellij](https://www.jetbrains.com/idea/download/?section=windows) ou [Eclipse](https://www.eclipse.org/downloads/)
- [MySQL](https://www.mysql.com/downloads/)
- [Postman](https://www.postman.com)
- [lombok](https://projectlombok.org/download)



<h2 id="rodandoApi">🎲 Rodando a Api</h2>

<h3> Clone este repositório</h3>

git clone <https://github.com/Rene-Antunes/restaraunt-API.git>

<h3>Configurando banco de dados</h3>
É necessário ter MySQL instalado em sua máquina, após instalação crie um banco de dados com nome <strong>restaurante</strong>. Pode atualizar o usuário e senha no arquivo <strong>application.properties</strong> para os dados do seu banco de dados.

<h3>Iniciar aplicação</h3>
Iniciar por meio da IDE iniciando a classe RestauranteApiApplication.java.

Pelo terminal:
```
java -jar target/restaurant-api.jar
```
```
spring.datasource.username=root
spring.datasource.password=12345678
```
ou utilizando o maven

```
mvn spring-boot:run
```
**A aplicação vai iniciar na porta http://localhost:8080**
