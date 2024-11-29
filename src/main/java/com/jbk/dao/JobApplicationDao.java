package com.jbk.dao;

import com.jbk.entities.JobApplication;

public interface JobApplicationDao {
    int saveApplication(JobApplication jobApplication);
    int updateApplicationStatus(int id, String status);
    int deleteApplication(int id);
}
