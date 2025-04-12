# Hotel Booking Application

## Overview

This project is a web application for the Landon Hotel, utilizing Spring Boot for the backend and Angular for the frontend. Key features implemented include displaying welcome messages in English and French, showing room prices in USD, CAD, and EUR, and presenting live online presentation times in ET, MT, and UTC.

## Technologies Used

### Backend

* Java
* Spring Boot
* Maven
* RESTful APIs
* Resource Bundles
* Multithreading

### Frontend

* Angular
* TypeScript
* HTML
* CSS
* Node.js
* npm

### Development Environment & Tools

* IntelliJ IDEA
* Git
* Docker

## Feature Implementation

### Language Translation (B1)

* Created resource bundles for English and French welcome messages.
* Developed a multithreaded Java class to retrieve messages.
* Implemented a REST Controller endpoint to serve the messages as a JSON array.
* Displayed the messages on the Angular frontend using data binding and `*ngFor`.

### Currency Display (B2)

* Used the Angular `CurrencyPipe` in the HTML to display room prices with $, C$, and € symbols on separate lines.

### Time Zone Conversion (B3)

* Created a Java method using `java.time` to convert and format times for ET, MT, and UTC.
* Implemented a REST Controller endpoint to provide the formatted times as JSON data.
* Displayed the presentation times on the Angular frontend.

## Setup

1.  Ensure IntelliJ IDEA, Node.js, Docker, Java (JDK), and Maven are installed.
2.  Navigate to the `UI` directory in the terminal and run `npm install` followed by `ng build` and `ng serve`.
3.  Navigate to the main project directory and run `mvn clean install` followed by `mvn spring-boot:run`.
4.  The application will be accessible at `http://localhost:8080` (backend) and `http://localhost:4200` (frontend).

## Git Repository

* **Repository URL:** `https://github.com/cbaguley3/AdvancedJava_Multithreading-Spring-Angular-Docker/edit/working_branch2`
* **Working Branch:** `working_branch2`

## Commit History (Relevant to this stage)

* Implemented language translation (B1).
* Implemented currency display (B2).
* Implemented time zone conversion (B3).
