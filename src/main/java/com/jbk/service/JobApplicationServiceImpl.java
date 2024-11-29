package com.jbk.service;

import com.jbk.dao.JobApplicationDao;
import com.jbk.entities.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationDao jobApplicationDAO;

    @Override
    public int submitApplication(JobApplication jobApplication) {
         return jobApplicationDAO.saveApplication(jobApplication);
    }

    @Override
    public int updateApplicationStatus(int id, String status) {
        return jobApplicationDAO.updateApplicationStatus(id, status);
    }

    @Override
    public int withdrawApplication(int id) {
        return jobApplicationDAO.deleteApplication(id);
    }
}
