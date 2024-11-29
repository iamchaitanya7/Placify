package com.jbk.service;

import com.jbk.entities.JobApplication;

public interface JobApplicationService {
    int submitApplication(JobApplication jobApplication);
    int updateApplicationStatus(int id, String status);
    int withdrawApplication(int id);
}
