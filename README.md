# Workforce Management Portal

A backend-focused **Workforce Management Portal** developed using **Java, Spring Boot, Spring Security, Spring Data JPA, Hibernate, MySQL, and REST APIs**.

The application provides **user and employee management** functionality with secure authentication, role-based access control, CRUD operations, input validation, global exception handling, and email-based OTP verification.

---

## 🚀 Features

* User registration
* Email-based OTP verification
* OTP validation and expiration handling
* Secure authentication using Spring Security
* Role-Based Access Control (RBAC)
* ADMIN and USER roles
* Employee management
* User management
* Complete CRUD operations
* RESTful API development
* JSON-based request and response handling
* Input validation
* Global exception handling
* Custom exception handling
* MySQL database integration
* JPA/Hibernate database operations
* Email service integration
* REST API testing using Postman

---

## 🛠️ Technologies Used

### Programming Language

* Java

### Backend Framework

* Spring Boot
* Spring MVC
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL

### API & Database Technologies

* REST APIs
* JDBC
* JSON

### Development Tools

* Maven
* Git
* GitHub
* Postman
* Eclipse
* Visual Studio Code

---

## 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── com
    │       └── springboot
    │           └── employeemanagement
    │               │
    │               ├── config
    │               │   └── SecurityConfig.java
    │               │
    │               ├── controller
    │               │   ├── EmployeeController.java
    │               │   └── UserController.java
    │               │
    │               ├── dto
    │               │   ├── RegisterRequest.java
    │               │   └── VerifyOtpRequest.java
    │               │
    │               ├── entity
    │               │   ├── Employee.java
    │               │   └── User.java
    │               │
    │               ├── exception
    │               │   ├── GlobalExceptionHandling.java
    │               │   ├── InvalidOtpException.java
    │               │   ├── OtpExpiredException.java
    │               │   ├── UserNotFoundException.java
    │               │   └── UserVerifiedException.java
    │               │
    │               ├── repository
    │               │   ├── EmployeeRepository.java
    │               │   └── UserRepository.java
    │               │
    │               ├── service
    │               │   ├── EmailService.java
    │               │   ├── EmployeeService.java
    │               │   ├── OtpService.java
    │               │   └── UserService.java
    │               │
    │               ├── util
    │               │
    │               └── EmployeeManagementSystemApplication.java
    │
    └── resources
        └── application.properties
```

---

## 🏗️ Application Architecture

The application follows a **layered backend architecture** to separate responsibilities and maintain a clean, maintainable codebase.

```text
                    Client
                      │
                      ▼
              REST Controller
                      │
                      ▼
                Service Layer
                      │
                      ▼
              Repository Layer
                      │
                      ▼
               MySQL Database
```

### Controller Layer

The Controller Layer handles incoming HTTP requests and provides REST API endpoints for:

* User management
* Employee management
* User registration
* OTP verification

Main controllers:

* `UserController`
* `EmployeeController`

### Service Layer

The Service Layer contains the application's business logic.

Main services include:

* `UserService`
* `EmployeeService`
* `OtpService`
* `EmailService`

### Repository Layer

The Repository Layer handles database interaction using **Spring Data JPA**.

Repositories include:

* `UserRepository`
* `EmployeeRepository`

### Entity Layer

The Entity Layer represents the application's database entities.

Main entities:

* `User`
* `Employee`

### DTO Layer

The DTO Layer is used to transfer request data between the client and application.

DTOs include:

* `RegisterRequest`
* `VerifyOtpRequest`

### Exception Layer

The Exception Layer provides centralized and custom exception handling.

Custom exceptions include:

* `InvalidOtpException`
* `OtpExpiredException`
* `UserNotFoundException`
* `UserVerifiedException`

---

## 🔐 Security

The application uses **Spring Security** to secure backend resources and control access to protected APIs.

The system supports two user roles:

```text
ADMIN
USER
```

### Role-Based Access Control

Role-Based Access Control (RBAC) is implemented to provide different permissions based on the authenticated user's role.

For example:

* **ADMIN** – Access to administrative and employee management operations
* **USER** – Access to permitted user-level operations

This helps ensure that protected resources can only be accessed by authorized users.

---

## 📧 OTP Verification

The application provides **email-based OTP verification** during account activation.

### Registration Flow

```text
User Registration
       │
       ▼
Generate OTP
       │
       ▼
Send OTP through Email
       │
       ▼
User Enters OTP
       │
       ▼
Verify OTP
       │
       ├────────────── Valid OTP
       │                    │
       │                    ▼
       │              Account Verified
       │
       ├────────────── Invalid OTP
       │                    │
       │                    ▼
       │             InvalidOtpException
       │
       └────────────── Expired OTP
                            │
                            ▼
                     OtpExpiredException
```

### OTP Handling

The system handles:

* OTP generation
* OTP delivery through email
* OTP validation
* OTP expiration
* Invalid OTP scenarios
* Already verified user scenarios

---

## 👨‍💼 Employee Management

The Employee Management module provides complete **CRUD functionality** for employee-related data.

### Supported Operations

| HTTP Method | Operation         |
| ----------- | ----------------- |
| POST        | Create Employee   |
| GET         | Retrieve Employee |
| PUT         | Update Employee   |
| DELETE      | Delete Employee   |

Employee operations are exposed through REST APIs and connected to the MySQL database using **Spring Data JPA and Hibernate**.

---

## 👤 User Management

The User Management module handles:

* User registration
* User verification
* User authentication
* Role management
* User-related operations

Spring Security is used to authenticate users and control access to protected resources.

---

## 🌐 REST APIs

The application exposes RESTful APIs for **user and employee management**.

The APIs use standard HTTP methods:

* `GET`
* `POST`
* `PUT`
* `DELETE`

### Request & Response Format

API communication uses **JSON-based request and response payloads**.

Example:

```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "role": "USER"
}
```

The APIs can be tested using **Postman**.

---

## 🗄️ Database

The application uses **MySQL** for persistent data storage.

**Spring Data JPA** and **Hibernate** are used for:

* Object-Relational Mapping (ORM)
* Entity management
* Database operations
* CRUD operations

### Main Entities

```text
User
Employee
```

---

## 🔄 Application Flow

The overall application flow can be represented as:

```text
Client
  │
  ▼
REST API Request
  │
  ▼
Controller
  │
  ▼
Spring Security
  │
  ▼
Service Layer
  │
  ▼
Repository
  │
  ▼
Hibernate / JPA
  │
  ▼
MySQL Database
  │
  ▼
JSON Response
```

For registration and verification:

```text
Register User
      │
      ▼
Generate OTP
      │
      ▼
Send OTP via Email
      │
      ▼
Verify OTP
      │
      ▼
Activate Account
      │
      ▼
Authenticate User
      │
      ▼
Access Authorized APIs
```

---

## ⚙️ Configuration

Application configuration is maintained in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

Configure your email service properties according to your email provider.

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/pallaviys2004/Workforce-Management-Portal.git
```

### 2. Open the Project

Open the project using:

* Eclipse
* IntelliJ IDEA
* Visual Studio Code

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE employee_management;
```

Update the database username and password in:

```text
application.properties
```

### 4. Configure Email Service

Add your email service configuration according to your email provider.

Do not commit email passwords or other sensitive credentials to GitHub.

### 5. Build the Project

Using Maven:

```bash
mvn clean install
```

### 6. Run the Application

Run:

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

## 🧪 API Testing

The REST APIs can be tested using **Postman**.

Testing includes:

* User registration
* OTP verification
* User authentication
* Employee creation
* Employee retrieval
* Employee update
* Employee deletion
* Unauthorized access testing
* Invalid request validation
* Exception handling

---

## 🛡️ Exception Handling

The application uses centralized exception handling to provide consistent error responses.

### Custom Exceptions

```text
InvalidOtpException
OtpExpiredException
UserNotFoundException
UserVerifiedException
```

Global exception handling is implemented using:

```text
GlobalExceptionHandling.java
```

This helps handle application errors in a centralized and maintainable manner.

---

## 🔒 Security Considerations

The application uses Spring Security for authentication and authorization.

Sensitive information should **never** be committed to GitHub.

Do not upload:

* Database passwords
* Email passwords
* API keys
* Secret keys
* Authentication credentials

Use environment variables or local configuration for sensitive information.

Example:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

---

## 📌 Key Highlights

* Developed a backend-focused workforce management system using **Java and Spring Boot**
* Implemented **RESTful APIs** for user and employee management
* Implemented **Spring Security** for authentication and authorization
* Added **Role-Based Access Control (RBAC)** with ADMIN and USER roles
* Implemented **email-based OTP verification**
* Developed complete **CRUD operations**
* Used **Spring Data JPA and Hibernate** for database operations
* Integrated **MySQL** for persistent data storage
* Implemented **input validation and global exception handling**
* Tested REST APIs using **Postman**
* Followed a structured **layered architecture**

---

## 📚 Concepts Demonstrated

This project demonstrates practical knowledge of:

* Core Java
* Object-Oriented Programming
* Spring Boot
* Spring MVC
* Spring Security
* Spring Data JPA
* Hibernate
* REST API development
* HTTP methods
* JSON
* Authentication
* Authorization
* Role-Based Access Control
* DTOs
* CRUD operations
* MySQL
* ORM
* Exception Handling
* Input Validation
* Email Integration
* Maven
* Git & GitHub
* API Testing with Postman

---

## 👩‍💻 Author

**Pallavi Y S**

Information Science and Engineering Graduate

### Technologies of Interest

* Java
* Spring Boot
* REST APIs
* SQL
* Spring Security
* Hibernate
* Backend Development
* AI/ML

---

## 📄 License

This project is developed for **educational and portfolio purposes**.
