# Rule Engine Application

## please view in code format

## Overview

The Rule Engine application is a flexible rule engine developed with Spring Boot that evaluates user eligibility based on various attributes such as age, department, income, and experience. It features dynamic rule creation and real-time evaluation through a RESTful API.

## Table of Contents

- [Application Overview](#application-overview)
- [Key Features](#key-features)
- [Technical Architecture](#technical-architecture)
- [Technologies Used](#technologies-used)
- [Dependencies](#dependencies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Sample Data](#sample-data)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Application Overview

The Rule Engine is designed to evaluate user eligibility based on configurable rules. It allows businesses to dynamically define and modify rules that dictate user qualifications based on attributes such as age, department, income, and experience.

## Key Features

- **Dynamic Rule Creation:** Users can create rules in real-time using a straightforward syntax that supports complex logical conditions with operators (AND, OR).
- **Rule Evaluation:** The application evaluates user data against defined rules, returning a boolean indicating eligibility.
- **Combine Rules:** Users can combine multiple rules into a single expression to simplify evaluation.
- **User-Friendly API:** Exposes a RESTful API for seamless interaction with other applications, including endpoints for rule management and evaluation.
- **Robust Data Management:** Utilizes Hibernate ORM for efficient data handling, storing rules and metadata in a MySQL database.

## Technical Architecture

The application is structured in a 3-tier architecture:

1. **Presentation Layer:** Built using Spring Boot, this layer handles incoming HTTP requests and provides RESTful endpoints.
2. **Service Layer:** Contains business logic, interacting with repositories for rule operations. This separation ensures clean code and maintainability.
3. **Data Layer:** Uses Hibernate for ORM, managing the persistence of rules and user data in a MySQL database.

## Technologies Used

- **Backend:** Java, Spring Boot, Hibernate
- **Database:** MySQL
- **Frontend:** HTML, CSS, JavaScript
- **Build Tool:** Maven

## Dependencies

To set up and run the application, the following dependencies are required:

- **Java 11 or higher**
- **Maven**
- **MySQL Database** (can be run in a Docker container for ease)

### Docker Setup

1. Install Docker (if not already installed).
2. Run the following command to start a MySQL container:

   ```bash
   docker run --name mysql-rule-engine -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=rule_engine_db -p 3306:3306 -d mysql:latest
Access the MySQL database using MySQL Workbench or any other client.

Getting Started
Prerequisites
Java 11 or higher
Maven
MySQL Server (or Docker)
Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/27AdityaSingh/rule-engine.git
cd rule-engine
Create a MySQL Database: If not using Docker, create the database manually:

sql
Copy code
CREATE DATABASE rule_engine_db;
Update application.properties: Modify the src/main/resources/application.properties file with your MySQL database credentials:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/rule_engine_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
Build the Project:

bash
Copy code
mvn clean install
Run the Application:

bash
Copy code
mvn spring-boot:run
Access the Application: Open a web browser and navigate to http://localhost:8080/index.html to access the frontend.

API Endpoints
Create Rule:

POST /api/rules
Request Body: { "ruleName": "Rule 1", "ruleAst": "((age > 30 AND department = 'Sales'))" }
Get All Rules:

GET /api/rules
Get Rule by ID:

GET /api/rules/{id}
Combine Rules:

POST /api/rules/combine
Request Body:
json
Copy code
[
  { "ruleAst": "((age > 30 AND department = 'Sales'))" },
  { "ruleAst": "((age < 25 AND department = 'Marketing'))" }
]
Evaluate Rule:

POST /api/rules/evaluate
Request Body:
json
Copy code
{
  "age": 35,
  "department": "Sales",
  "salary": 60000,
  "experience": 3
}
Query Parameter: ruleAst
Sample Data
You can use the following sample data to test the evaluation endpoint:

json
Copy code
{
  "age": 35,
  "department": "Sales",
  "salary": 60000,
  "experience": 3
}
Usage
Use tools like Postman or cURL to interact with the API endpoints and test the functionality of the rule engine.

Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

sql
Copy code

Feel free to copy and paste this into your `README.md` file. Let me know if you need any further modifications!





