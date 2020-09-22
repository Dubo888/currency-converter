Currency converter
-----------------------------------------------------------

I'm going to make a web application with Spring Boot for the backend and Bootstrap and Jquery for the frontend. The idea is simple, to convert a given value from a currency to another.

How to run the project:
-----------------------

This project is using redis to store locally the currencies conversion rates. So after installing redis. You'll need to execute:

* redis-server

On a separate terminal and since this is a maven project you just need to go to the root of the project and perform the command:

* mvn clean install


This will run the tests and create the jar file.

By default the project will run on port 8080.

