# Gastromatic API

[![Build Status](https://travis-ci.org/matuella/gastromatic.svg?branch=master)](https://travis-ci.org/matuella/gastromatic)

## Introduction

The main purpose of this project is to provide part of a microservices structure, more specifically the back-end (RESTful services). The front-end - that is consuming these services - can be found [here](https://github.com/matuella/gastromatic-front). Also, this is a Final Paper project to the Technologist Analysis and Systems Development degree.

### Architecture overview

![TBI](http://url/to/img.png)

### Development process

![TBI](http://url/to/img.png)

### Technologies

- Spring Boot (Data, JPA, REST);
- JSOG (cyclic JSON mapping);
- Heroku (hosting);
- TravisCI (continuous integration);
- JUnit (testing);

### Project Availability

This API is being hosted on heroku and uses the postgresql as database. On the *src/main/resources* folder there are two configuration files. One is the **application.properties**, that Spring maps the database connection, and contains both MySQL and PostgreSQL configuration, that can be quickly swapped by commenting/uncommenting the indicated lines. The other is the **data.sql**, this one is executed everytime the application starts (default name by Spring), used for development and makes sense only when the database is recreated everytime it starts, due to the property *spring.jpa.hibernate.ddl-auto* setted as *create*.

## Running the Project

To run the project locally, you should probably use Tomcat 8.0.37 as the Application Server, not only because it's the recommended by Spring, but its compatibility really pays off the time spent deploying. If you don't have a IDE to help you build and deploy the project, you should do the following:

- Download and unzip Tomcat 8.0.37, Maven and MySQL (or PostgreSQL if you prefer);
- Open a cmd and go into the project root folder (where the pom.xml is). Execute : `mvn clean install`. This will basically clean the target folder and build the project for you;
- Start the MySQL/PostgreSQL;
- Use the Tomcat GUI or follow the instructions [here](https://tomcat.apache.org/tomcat-8.0-doc/manager-howto.html).
