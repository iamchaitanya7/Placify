package com.jbk.entities;

import com.jbk.enums.ApplicationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "student_id", nullable = false)
    private long studentId;

    @Column(name = "job_posting_id", nullable = false, unique = true)
    private long jobPostingId;

    @Column(name = "status", nullable = false)
    private String status = ApplicationStatus.APPLIED.getValue ();

    // Constructors, getters, and setters
    public JobApplication () {
    }

    public JobApplication (int id, long studentId, long jobPostingId, String status) {
        this.id = id;
        this.studentId = studentId;
        this.jobPostingId = jobPostingId;
        this.status = status;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public long getStudentId () {
        return studentId;
    }

    public void setStudentId (long studentId) {
        this.studentId = studentId;
    }

    public long getJobPostingId () {
        return jobPostingId;
    }

    public void setJobPostingId (long jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    @Override
    public String toString () {
        return "JobApplication{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", jobPostingId=" + jobPostingId +
                ", status='" + status + '\'' +
                '}';
    }
}
