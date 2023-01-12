# Spring Boot MicroService for Calendar

# Table of contents

* [About the project](#about-the-project)
* [Getting started](#getting-started)
  * [Frameworks](#frameworks)
  * [Prerequesites](#prerequesites)
  * [Installation](#installation)
  * [Set up the database](#setup-the-database)
  * [Run](#run)
  * [Run tests](#run-tests)
* [Tree structure](#tree-structure)
* [Database](#database)
* [Acknowledgments](#acknowledgments)
* [License](#license)

## About the project

The purpose of this application is to give the timetable for the whole year of a student or a teacher by entering his/her number, name or surname.

## Getting started

### Frameworks

The project is built using the **Java Programming Language** under the **Spring Boot** framework.

Spring Boot is a framework used to build stand-alone application and production ready spring applications. It facilitates the way to launch and deploy API REST based application without huge configurations.

For more information about Spring Boot, view the [official documentation][spring-boot].

### Prerequesites

Before launch the application, you have to satisfy the following requirements.

[Git][git] must be installed and configured on your machine in order to clone the repository and pull the new updates.

A [MySql][mysql] server must be installed on your machine so that the application can connect to the database. It is recommended to have a good knowledge of relational databases. Click here to download [MySql community server][mysql-download].

### Installation
Clone the repository by using the following command:
````
git clone https://github.com/RISE-Remote-Intranet-School-Environment/RISE-Calendar-2.git
````
### Setup the database

First, you have to import the database in MYSQL Workbench, to do that, you have to import the dump folder located in `/Assets/dumpsylla/`.

The configurations must be put in the folder with the name `application.properties`.

You must specify the following parameters:

* application-port
  * Port used by your application.
* database-ip
  * IP address or domain name of your database.
* database-port
  * `3306` by default.
* database-name
* database-username
* database-password
* application-name

This is the example of our `application.properties` :
```properties
spring.datasource.url = jdbc:mysql://localhost:3306/calendar
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
server.port=8081
```
### Run
Run CalendarApplication located in `src\main\java\com\ecam\calendar/CalendarApplication.java` with your IDE (we used `IntelliJ`.

### Run tests

The unit test framework used is [JUnit][junit].

To run the tests, we run the project in the `CalendarApplicationTests.java`

## Tree Structure

```bash
Calendar
    ├───.mvn
    │   └───wrapper
    └───src
        ├───main
        │   ├───java
        │   │   └───Calendar
        │   │       └───Calendar
        │   │           ├───controller
        │   │           ├───model
        │   │           ├───repository
        │   │           └───service
        │   └───resources
        │        └───application.properties
        └───test
            └───java
                └───Calendar
                    └───Calendar
                        └───controller
```
## Database

As explained above, we use a relational database which is MySQL.

Here is the database relational diagram used in the project.

![Database diagram][database-diagram]

## Code documentation

The code is documented using `Javadoc`. You can view the code documentation by loading [index.html][code-documentation] file.

## Some Improvements
* Search the timetable off a room (the table is already created).
* Create a documented API.

## Acknowledgments

* [Spring Boot Reference Documentation][spring-boot-documentation]
* [Spring Framework Documentation][spring-documentation]
* [JUnit User Guide][junit-guide]
* [Postman][postman]
* [Introduction to Spring Data JPA][jpa-tutorial]

## License

Distributed under the AGPL-3.0 License. See [LICENSE.md][license] for more information.

<!-- Internal file links -->
[database-diagram]: ./database_diagram.png
[license]: ./LICENSE.md
[code-documentation]: ./JavaDoc/index.html

<!-- Links -->
[spring-boot]: https://spring.io/projects/spring-boot
[spring-boot-documentation]: https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiM1Z3Gg777AhUKiP0HHb88AK8QFnoECBYQAQ&url=https%3A%2F%2Fdocs.spring.io%2Fspring-boot%2Fdocs%2Fcurrent%2Freference%2Fhtmlsingle%2F&usg=AOvVaw1hehprHejWPlOVUg-kvg1V
[git]: https://git-scm.com/
[mysql]: https://www.mysql.com
[mysql-download]: https://dev.mysql.com/downloads/mysql/
[docker]: https://www.docker.com/products/docker-desktop/
[docker-documentation]: https://docs.docker.com/get-started/
[swagger-ui]: https://swagger.io/tools/swagger-ui/
[api-documentation]: https://beta.bachelay.eu/ms-studentHelp
[postman]: https://www.postman.com/
[spring-documentation]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/index.html
[junit]: https://junit.org/junit5/
[junit-guide]: https://junit.org/junit5/docs/current/user-guide/
[jpa]: https://spring.io/guides/gs/accessing-data-jpa/
[jpa-tutorial]: https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa