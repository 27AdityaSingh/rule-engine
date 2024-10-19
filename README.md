Rule Engine Application
Overview
The Rule Engine application is a flexible rule engine developed with Spring Boot that evaluates user eligibility based on various attributes such as age, department, income, and experience. It features dynamic rule creation and real-time evaluation through a RESTful API.

Table of Contents
Application Overview
Key Features
Technical Architecture
Technologies Used
Dependencies
Getting Started
API Endpoints
Sample Data
Usage
Contributing
License
Application Overview
The Rule Engine is designed to evaluate user eligibility based on configurable rules. It allows businesses to dynamically define and modify rules that dictate user qualifications based on attributes such as age, department, income, and experience.

Key Features
Dynamic Rule Creation: Users can create rules in real-time using a straightforward syntax that supports complex logical conditions with operators (AND, OR).
Rule Evaluation: The application evaluates user data against defined rules, returning a boolean indicating eligibility.
Combine Rules: Users can combine multiple rules into a single expression to simplify evaluation.
User-Friendly API: Exposes a RESTful API for seamless interaction with other applications, including endpoints for rule management and evaluation.
Robust Data Management: Utilizes Hibernate ORM for efficient data handling, storing rules and metadata in a MySQL database.
Technical Architecture
The application is structured in a 3-tier architecture:

Presentation Layer: Built using Spring Boot, this layer handles incoming HTTP requests and provides RESTful endpoints.
Service Layer: Contains business logic, interacting with repositories for rule operations. This separation ensures clean code and maintainability.
Data Layer: Uses Hibernate for ORM, managing the persistence of rules and user data in a MySQL database.
Technologies Used
Backend: Java, Spring Boot, Hibernate
Database: MySQL
Frontend: HTML, CSS, JavaScript
Build Tool: Maven
Dependencies
To set up and run the application, the following dependencies are required:

Java 11 or higher
Maven
MySQL Database (can be run in a Docker container for ease)
Docker Setup (Optional)
If you prefer using Docker for your MySQL setup, follow these steps:

Install Docker: If you haven't installed Docker yet, download and install it from Docker's official site.

Run MySQL in a Docker Container: Open your terminal and run the following command:

bash
Copy code
docker run --name mysql-rule-engine -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=rule_engine_db -p 3306:3306 -d mysql:latest
This command creates and runs a MySQL container with the database named rule_engine_db.

Getting Started
Prerequisites
Ensure you have the following software installed on your machine:

Java 11 or higher: Download Java.
Maven: Download Maven.
MySQL Server: Download MySQL and install it.
(Optional) Docker: Download Docker if you wish to use it.
Step-by-Step Setup Instructions
Step 1: Clone the Repository
Open your terminal (Command Prompt on Windows or Terminal on Mac).

Copy and paste the following command and press Enter:

bash
Copy code
git clone https://github.com/27AdityaSingh/rule-engine.git
Navigate to the project directory by typing:

bash
Copy code
cd rule-engine
Step 2: Set Up the MySQL Database
You can set up MySQL either directly or using Docker. Choose one of the options below.

Option A: Install MySQL Directly
Create a New Database:

Open MySQL Workbench or any MySQL client.
Run the following command to create a new database:
sql
Copy code
CREATE DATABASE rule_engine_db;
Configure Database Connection:

Open the application.properties file located at src/main/resources/application.properties.
Update the following lines with your MySQL connection details:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/rule_engine_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
(Replace root with your actual MySQL username and password if they are different.)

Option B: Run MySQL Using Docker
Run MySQL in a Docker Container:

If you have Docker installed, run the following command in your terminal:
bash
Copy code
docker run --name mysql-rule-engine -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=rule_engine_db -p 3306:3306 -d mysql:latest
Configure Database Connection:

Open the application.properties file in your project (same as above) and ensure the following lines are there:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/rule_engine_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
Step 3: Build the Application
In your terminal, make sure you are in the rule-engine directory.

Run the following command to build the application:

bash
Copy code
mvn clean install
(This may take a few minutes, and you’ll see messages in the terminal as it builds.)

Step 4: Run the Application
After the build is complete, start the application with this command:

bash
Copy code
mvn spring-boot:run
You should see some messages indicating that the application is running.

Step 5: Access the Frontend
Open your web browser (like Chrome, Firefox, or Safari).

Go to the following URL:

http://localhost:8080/index.html

This will open the Rule Engine user interface!

API Endpoints
You can interact with the application using these endpoints. Here are some basic operations:

Create a Rule:

Method: POST
Endpoint: /api/rules
Request Body:
json
Copy code
{
  "ruleName": "Rule 1",
  "ruleAst": "((age > 30 AND department = 'Sales'))"
}
Get All Rules:

Method: GET
Endpoint: /api/rules
Get Rule by ID:

Method: GET
Endpoint: /api/rules/{id} (replace {id} with the actual rule ID)
Combine Rules:

Method: POST
Endpoint: /api/rules/combine
Request Body:
json
Copy code
[
  { "ruleAst": "((age > 30 AND department = 'Sales'))" },
  { "ruleAst": "((age < 25 AND department = 'Marketing'))" }
]
Evaluate a Rule:

Method: POST
Endpoint: /api/rules/evaluate
Request Body:
json
Copy code
{
  "age": 35,
  "department": "Sales",
  "salary": 60000,
  "experience": 3
}
Query Parameter: ruleAst (e.g., ruleAst=((age > 30 AND department = 'Sales')))
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


