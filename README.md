# Workforce Management Portal

A backend-focused **Workforce Management Portal** developed using **Java, Spring Boot, Spring Security, Spring Data JPA, Hibernate, MySQL, and REST APIs**.

The application provides user and employee management functionality with secure authentication, role-based access control, CRUD operations, input validation, global exception handling, and email-based OTP verification.

---

## 🚀 Features

- User registration
- Email-based OTP verification
- OTP validation and expiration handling
- Secure authentication using Spring Security
- Role-Based Access Control (RBAC)
- ADMIN and USER roles
- Employee management
- User management
- Complete CRUD operations
- RESTful API development
- JSON-based request and response handling
- Input validation
- Global exception handling
- Custom exception handling
- MySQL database integration
- JPA/Hibernate database operations
- Email service integration
- REST API testing using Postman

---

## 🛠️ Technologies Used

### Programming Language
- Java

### Backend Framework
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate

### Database
- MySQL

### API & Database Technologies
- REST APIs
- JDBC
- JSON

### Development Tools
- Maven
- Git
- GitHub
- Postman
- Eclipse
- Visual Studio Code

---

## 📂 Project Structure

```text
src
└── main
    └── java
        └── com
            └── springboot
                └── employeemanagement
                    │
                    ├── config
                    │   └── SecurityConfig.java
                    │
                    ├── controller
                    │   ├── EmployeeController.java
                    │   └── UserController.java
                    │
                    ├── dto
                    │   ├── RegisterRequest.java
                    │   └── VerifyOtpRequest.java
                    │
                    ├── entity
                    │   ├── Employee.java
                    │   └── User.java
                    │
                    ├── exception
                    │   ├── GlobalExceptionHandling.java
                    │   ├── InvalidOtpException.java
                    │   ├── OtpExpiredException.java
                    │   ├── UserNotFoundException.java
                    │   └── UserVerifiedException.java
                    │
                    ├── repository
                    │   ├── EmployeeRepository.java
                    │   └── UserRepository.java
                    │
                    ├── service
                    │   ├── EmailService.java
                    │   ├── EmployeeService.java
                    │   ├── OtpService.java
                    │   └── UserService.java
                    │
                    ├── util
                    │
                    └── EmployeeManagementSystemApplication.java


🏗️ Application Architecture

The application follows a layered backend architecture:

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
Controller Layer

Handles incoming HTTP requests and provides REST API endpoints for:

User management
Employee management
Registration
OTP verification
Service Layer

Contains the application's business logic.

Main services include:

UserService
EmployeeService
OtpService
EmailService
Repository Layer

Provides database interaction using Spring Data JPA.

Repositories include:

UserRepository
EmployeeRepository
Entity Layer

Contains the application's database entities:

User
Employee
DTO Layer

Used to transfer request data between the client and application.

DTOs include:

RegisterRequest
VerifyOtpRequest
Exception Layer

Provides centralized and custom exception handling.

Custom exceptions include:

InvalidOtpException
OtpExpiredException
UserNotFoundException
UserVerifiedException
🔐 Security

The application uses Spring Security to secure backend resources.

The system supports two user roles:

ADMIN
USER

Role-Based Access Control (RBAC) is implemented to provide different permissions for different user roles.

📧 OTP Verification

The application provides email-based OTP verification during account activation.

Registration Flow
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
       ├── Valid OTP
       │       │
       │       ▼
       │   Account Verified
       │
       ├── Invalid OTP
       │       │
       │       ▼
       │   InvalidOtpException
       │
       └── Expired OTP
               │
               ▼
        OtpExpiredException
👨‍💼 Employee Management

The Employee Management module provides CRUD functionality for employee-related data.

Supported operations include:

Create Employee
Retrieve Employee
Update Employee
Delete Employee

The operations are exposed through REST APIs and connected to the MySQL database using Spring Data JPA and Hibernate.

👤 User Management

The User module handles:

User registration
User verification
User authentication
Role management
User-related operations

Spring Security is used to control access to protected resources.

🌐 REST APIs

The application exposes RESTful APIs for user and employee management.

The APIs use standard HTTP methods such as:

GET
POST
PUT
DELETE

API communication uses JSON request and response payloads.

The APIs can be tested using Postman.

🗄️ Database

The application uses MySQL for persistent data storage.

Spring Data JPA and Hibernate are used for object-relational mapping and database operations.

Main entities:

User
Employee
⚙️ Configuration

Configure the application properties in:

src/main/resources/application.properties

Example configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

Configure your email service properties according to your email provider.

⚠️ Security Note

Do not upload real:

Database passwords
Email passwords
API keys
Secret keys
Authentication credentials

to GitHub.

Use environment variables or local configuration for sensitive information.
