# Rule Engine Application

## Overview

The **Rule Engine** application is a flexible rule evaluation tool developed using **Spring Boot**. It evaluates user eligibility based on various attributes such as age, department, income, and experience. The application features dynamic rule creation and real-time evaluation through a RESTful API. Businesses can define, modify, and evaluate rules efficiently, making it easier to manage eligibility criteria for various programs or promotions.

### Key Features

- **Dynamic Rule Creation:** Create and manage rules in real-time using a straightforward syntax that supports complex logical conditions (AND, OR).
- **Rule Evaluation:** Evaluate user data against defined rules, returning a boolean indicating whether the user meets the eligibility criteria.
- **Combine Rules:** Combine multiple rules into a single expression for simplified evaluations.
- **User-Friendly API:** Expose a RESTful API for easy interaction with other applications, including endpoints for rule management and evaluation.
- **Robust Data Management:** Utilize Hibernate ORM for efficient data handling, storing rules and metadata in a MySQL database.

### Technical Architecture

The application follows a **3-tier architecture**:

1. **Presentation Layer:** Built using Spring Boot, this layer handles incoming HTTP requests and provides RESTful endpoints.
2. **Service Layer:** Contains the business logic, interacting with repositories for rule operations. This separation ensures clean code and maintainability.
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

### Docker Setup (Optional)

1. **Install Docker:** Download and install Docker from [Docker's official website](https://www.docker.com/get-started).
2. **Run MySQL Container:**
   Open a terminal and run the following command to start a MySQL container:

   ```bash
   docker run --name mysql-rule-engine -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=rule_engine_db -p 3306:3306 -d mysql:latest




