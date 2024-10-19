# Rule Engine

A flexible rule engine application developed with Spring Boot that evaluates user eligibility based on various attributes such as age, department, income, and experience. The application features dynamic rule creation and real-time evaluation through a RESTful API.

## Table of Contents

- [Application Overview](#application-overview)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Sample Data](#sample-data)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Application Overview

The **Rule Engine** is a powerful and flexible application designed to evaluate user eligibility based on various configurable rules. It allows businesses to dynamically define and modify rules that dictate user qualifications based on attributes such as age, department, income, spending, and experience. 

### Key Features

- **Dynamic Rule Creation**: Users can create rules in real-time using a straightforward syntax that can express complex logical conditions, such as combining multiple criteria using logical operators (AND, OR).

- **Rule Evaluation**: The application can evaluate any user data against defined rules, returning a boolean value indicating whether the user meets the eligibility criteria.

- **Combine Rules**: Users can combine multiple rules into a single rule, which simplifies the evaluation process and reduces redundancy.

- **User-Friendly API**: The application exposes a RESTful API that allows other applications to interact with the rule engine seamlessly. This includes endpoints for creating rules, retrieving existing rules, combining rules, and evaluating user data against rules.

- **Robust Data Management**: Utilizing Hibernate ORM for database interactions ensures efficient data handling and integrity. The application stores rules and their metadata in a MySQL database, allowing for persistent storage and retrieval.

### Technical Architecture

The application is structured in a 3-tier architecture, which includes:

1. **Presentation Layer**: 
   - Built using Spring Boot, the presentation layer handles incoming HTTP requests and routes them to the appropriate service methods. It provides RESTful endpoints for clients to interact with the rule engine.

2. **Service Layer**: 
   - This layer contains the business logic for the application. It interacts with the data layer (repositories) to perform operations such as creating, retrieving, combining, and evaluating rules. This separation of concerns ensures that the presentation logic is decoupled from the business logic.

3. **Data Layer**: 
   - The data layer uses Hibernate to map Java objects to database tables. It manages the persistence of rules and user data in a MySQL database, ensuring that data is safely stored and easily accessible.

### Use Cases

- **Eligibility Criteria Management**: Businesses can define and modify eligibility criteria for various programs or promotions without needing extensive code changes, making the application flexible and adaptable.

- **Real-time Decision Making**: The application can be integrated into user registration or application processes to make immediate decisions based on the configured rules, enhancing user experience and operational efficiency.

- **Analytics and Reporting**: By storing user data and evaluation results, the application can be extended to provide insights and analytics on user eligibility trends and rule effectiveness.

### Future Enhancements

- **User-Defined Functions**: Implement support for user-defined functions within the rule language for more advanced conditions and calculations.

- **Web Interface**: Develop a user-friendly web interface for non-technical users to manage rules visually.

- **Enhanced Rule Language**: Expand the syntax and capabilities of the rule language to accommodate more complex scenarios and use cases.

## Features

- Create, retrieve, and evaluate eligibility rules.
- Combine multiple rules into a single expression.
- RESTful API for integration with other services.
- Supports dynamic modification of rules.

## Technologies

- **Java**: Version 11 or higher
- **Spring Boot**: For building the RESTful API
- **Hibernate**: For ORM (Object-Relational Mapping)
- **MySQL**: For database management
- **Maven**: For dependency management

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL Server

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/27AdityaSingh/rule-engine.git
   cd rule-engine
Create a MySQL database:

sql
Copy code
CREATE DATABASE rule_engine_db;
Update the application.properties file in src/main/resources with your MySQL database credentials.

Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
API Endpoints
Create Rule
POST /api/rules
Request Body: { "ruleName": "Rule 1", "ruleAst": "((age > 30 AND department = 'Sales'))" }
Get All Rules
GET /api/rules
Get Rule by ID
GET /api/rules/{id}
Combine Rules
POST /api/rules/combine
Request Body: [ { "ruleAst": "((age > 30 AND department = 'Sales'))" }, { "ruleAst": "((age < 25 AND department = 'Marketing'))" } ]
Evaluate Rule
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
Query Parameter: ruleAst=<Rule AST String>
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
You can use tools like Postman or cURL to interact with the API endpoints and test the functionality of the rule engine.

Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.
