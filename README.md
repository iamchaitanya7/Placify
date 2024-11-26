# Placify

## About the Project  
**Placify** is a Spring Boot-based REST API designed to streamline the campus recruitment process. It facilitates seamless management of job postings, student applications, and interviews, ensuring efficient communication between students and employers. The primary entities in the system include Students, Users, Job Postings, Job Applications, and Interviews.  

### Objectives  
- Automate the job application process via REST APIs for seamless integration.  
- Ensure data accuracy with automated validation and storage of records.  
- Facilitate smooth interaction between students and employers to enhance hiring workflows.  

---

## Workflow  

1. **Student Registration:**  
   - Students can register on the platform and log in to access job postings.  

2. **Viewing Job Postings:**  
   - Students can browse and view all available job opportunities.  

3. **Applying for a Job:**  
   - Students can apply for jobs, creating a new application with the status `APPLIED`.  

4. **Approval of Applications:**  
   - Employers review applications and update the status to `APPROVED` if selected.  

5. **Scheduling Interviews:**  
   - Approved candidates can schedule interviews, linked to their job applications.  

---

## Project Structure  

Placify follows a **layered architecture**:  

1. **Controller Layer:** Handles HTTP requests, validates input, and returns responses.  
2. **Service Layer:** Implements business logic, coordinates between layers, and ensures data integrity.  
3. **DAO Layer:** Manages database operations and abstracts SQL commands.  

---

## Technology Stack  

- **Backend Framework:** Spring Boot 2  
- **Database:** MySQL  
- **ORM Framework:** Hibernate 5  
- **Programming Language:** Java (JDK 1.8)  
- **Build Tool:** Maven  
- **Development Environment:** Eclipse  
- **API Testing Tool:** Postman  

---

## Modules and Key APIs  

### 1. User Module  
- Manages user authentication and management.  
#### Key Endpoints:  
- `POST /auth/login` - Authenticate user credentials.  
- `POST /user/createUser` - Add a new user.  
- `GET /user/allUsers` - Retrieve all registered users.  

### 2. Student Module  
- Handles student registration and profile management.  
#### Key Endpoints:  
- `POST /students/register` - Register a new student.  
- `GET /students/allStudents` - List all students.  
- `DELETE /students/deleteStudent/{id}` - Delete a student.  

### 3. Job Posting Module  
- Manages job postings and updates.  
#### Key Endpoints:  
- `POST /job-postings/createJob` - Add a job posting.  
- `GET /job-postings/allJobs` - Retrieve all job postings.  

### 4. Job Application Module  
- Allows students to apply for jobs and track application status.  
#### Key Endpoints:  
- `POST /jobApplication/apply` - Submit a job application.  
- `PUT /jobApplication/updateStatus/{id}/{status}` - Update application status.  

### 5. Interview Module  
- Manages interview scheduling and tracking.  
#### Key Endpoints:  
- `POST /interview/schedule` - Schedule an interview.  
- `PUT /interview/updateStatus/{id}/{status}` - Update interview status.  

---

## Future Enhancements  

1. **Admin Dashboard:**  
   - Add analytics and reporting for job postings and applications.  

2. **Notification System:**  
   - Email/SMS alerts for application status changes and interview reminders.  

3. **AI Integration:**  
   - Use machine learning to recommend jobs based on student profiles.  

4. **Third-Party Integration:**  
   - Integrate with platforms like LinkedIn for easy resume imports and profile verification.  

5. **Mobile Application Support:**  
   - Create a mobile-friendly version for better accessibility.  

---

## How to Run  

1. Clone the repository:  
```bash
   git clone https://github.com/your-username/Placify.git
```
2. Navigate to the project directory:
  ```bash
  cd Placify
```
3. Build the project:
  ```bash
  mvn clean install
```

4. Run the application:
  ```bash
  mvn spring-boot:run
```
5. Access the API endpoints using Postman or any REST client.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
For questions or support, contact:

Author: Chaitanya Gawali,
Email: chaitanyagawalipatil@gmail.com,
GitHub: iamchaitanya7
