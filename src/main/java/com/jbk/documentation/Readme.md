# Placify: Job Placement Portal

Placify is a web application designed to connect students with job opportunities. This project is currently under development, with more features and functionalities planned for future implementation.  This `README` will be updated as the project progresses.

## Current Features

* **Data Models:**  The project has defined entity classes for key components of a job placement system:
    * **`Student`:** Stores student information (ID, name, email, password, contact number, department, graduation year).
    * **`JobPosting`:**  Stores details about job postings (ID, job title, company name, description, location, eligibility criteria).
    * **`JobApplication`:**  Tracks student applications to job postings (ID, student ID, job posting ID, application status).
    * **`Interview`:**  Manages interview scheduling and status (ID, student ID, job application ID, interview date, interview status).
    * **`User`:** Stores user credentials for authentication (username, password, security question/answer, role).
* **Persistence Layer:** Uses Hibernate for database interaction and object-relational mapping. The entities are annotated with JPA annotations for persistence.
* **Backend Framework:** Built using Spring Boot, providing a robust foundation for building RESTful web services and other backend functionalities.

## Future Features (Roadmap)

* **REST API Endpoints:**  Implementation of RESTful APIs for managing students, job postings, applications, and interviews.  This will allow frontend clients (web or mobile) to interact with the system.
* **User Authentication and Authorization:** Secure the application by implementing user login, registration, and role-based access control.
* **Search and Filtering:** Allow students to search and filter job postings based on various criteria (keywords, location, company, etc.).
* **Application Workflow:** Implement the complete application workflow, including application submission, status updates, interview scheduling, and offer management.
* **Notification System:**  Notify students and recruiters about application updates, interview schedules, and other important events.
* **Frontend Development:** Develop a user-friendly web interface for students and recruiters to interact with the system.
* **Reporting and Analytics:**  Generate reports and analytics on job placement data.

## Technologies Used

* **Java:** Primary programming language.
* **Spring Boot:** Backend framework.
* **Hibernate:** ORM framework for database persistence.
* **MySQL:** Database (assumed, but not explicitly mentioned in the provided code).
* **JPA (Jakarta Persistence API):**  For managing persistent entities.

## Project Setup

1. **Database Configuration:**
    * Create a MySQL database (name not yet specified).
    * Configure the database connection details in a `hibernate.cfg.xml` file (or using Spring Boot's application.properties/yaml).  Ensure this configuration file is correctly placed on the classpath.  Include the JPA annotated entity classes in your Hibernate mapping.
2. **Build and Run:**
    * Build the project using Maven (if `pom.xml` is provided) or your preferred build tool.
    * Run the `PlacifyApplication.java` class to start the Spring Boot application.

## Workflow

The intended workflow of the application, once fully implemented, will be as follows:

1. **User Registration and Login:** Students and recruiters will register and log in to the system.
2. **Job Posting:** Recruiters will post job openings, providing details about the position and requirements.
3. **Job Search and Application:** Students will search for jobs and submit applications.
4. **Application Review:** Recruiters will review applications and shortlist candidates.
5. **Interview Scheduling:**  Interviews will be scheduled with shortlisted candidates.
6. **Interview Management:** Track interview feedback and status.
7. **Offer Management:**  Extend job offers to selected candidates.

## Code Structure

* **`com.jbk.entities`:** Contains the entity classes representing database tables.
* **`com.jbk.PlacifyApplication`:**  Main application class.
* *(Other packages and classes will be added as the project evolves.)*

## Contributing

This project is currently under development.  Contributions and suggestions are welcome.


## License

Under MIT Licensed.