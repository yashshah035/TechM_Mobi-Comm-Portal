# Mobile Prepaid Recharge Application

## Project Overview

This project is a multi-tiered web-based solution for Mobile Prepaid Recharge, developed as part of the TechM JFS Capstone Project. It implements a microservices architecture with a Java Spring Boot backend and an Angular frontend.

## Features

- Single Page Application (SPA) using Angular with REST API integration
- Responsive Web Design using Bootstrap
- CRUD REST API functionality with Spring Boot and Spring-Data JPA
- Role-based Authentication and Authorization
- Admin and Prepaid Mobile User functionalities
- Plan management and recharge history tracking
- Payment simulation with multiple options (UPI, Bank Transfer, Credit/Debit Card)

## Tech Stack

### Backend
- Java 8
- Spring Boot
- Spring MVC
- Hibernate/JPA
- RESTful Services

### Frontend
- Angular
- HTML5
- CSS3
- Bootstrap
- TypeScript

### Database
- MySQL 

### DevOps & Tools
- Git
- Maven
- Docker

## Getting Started

### Prerequisites
- JDK 8 or higher
- Node.js and NPM
- Maven
- SQL

### Installation

1. Clone the repository:

``` bash
git clone https://github.com/yashshah035/TechM_Mobi-Comm-Portal
```
2. Backend Setup:

``` bash
cd springapp
mvn clean install
mvn spring-boot:run
```

3. Frontend Setup:

``` bash
cd angularapp
npm install
ng serve
```
3. Database:

   Create `mpr_db` named databse first in MySQL. Paste coorect jdbc localhost path in application.properties

4. Access the application at `http://localhost:4200`. 

Note: replace '4200' with the port as you will see in your terminal. 



## Deployment

The application is deployed on `localhost`. Application can deploy to dedicated servers or using cloud based servers.


## Acknowledgments

- Tech Mahindra for providing the project requirements and guidance.
