# Gastromatic API

[![Build Status](https://travis-ci.org/matuella/gastromatic.svg?branch=master)](https://travis-ci.org/matuella/gastromatic)

### Intention

The main purpose of this project is to provide a RESTful web services back-end part of a microservice structure, the front-end that is consuming this services can be found [here](https://github.com/matuella/gastromatic-front). Also, this is a Final Paper project to the Technologist Analysis and Systems Development degree.

###Technologies

- Spring Boot (Data, JPA, REST);
- JSOG (cyclic JSON mapping);
- Heroku (hosting);
- TravisCI (continuous integration);
- JUnit (testing);

###Project Availability

This API is being hosted on heroku and uses a postgresql database. On the *src/main/resources* folder there are two configuration files. One is the **application.properties**, that Spring maps the database connection, it has the MySQL and PostgreSQL configuration, that can be switched by commenting/uncommenting the indicated lines. The other is the **data.sql**, this one is executed everytime the application starts (default name by Spring), used for development and makes sense only when the database is recreated everytime it starts, due to the propery *spring.jpa.hibernate.ddl-auto* setted as *create*.

- [This project (back-end)](...);
- [Front-end]().
