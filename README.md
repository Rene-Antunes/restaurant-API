<h1>✅ Status do projeto</h1>

> :construction: API Rest feito em Java com Spring restaraunt-API em construção :construction:

<h2 id="sobre" >Descrição do Projeto </h2>
Sistema de gerenciamento de restaurante ou lanchonete. Este sistema é uma API Rest em Java que permite o CRUD de funcionários, Produtos, fotos de produtos, mesas do estabelicimento e tipo de pagamento que pode ser aceito, permite também gerar pedidos e gerenciar seus status ex: criado, pronto, entregue. É possível gerenciar o tipo de permissão de cada funcionário para administrar o sistema. O sistema foi feito com baixo acoplamento sendo possível implementar com facilidade novas features futuramente.


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
