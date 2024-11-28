package com.jbk.service;

import com.jbk.dao.JobPostingDao;
import com.jbk.entities.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingDao jobPostingDao;

    @Override
    public int createJob(JobPosting jobPosting) {
        return jobPostingDao.saveJob(jobPosting);
    }

    @Override
    public List<JobPosting> retrieveAllJobs() {
        return jobPostingDao.getAllJobs();
    }

    @Override
    public JobPosting retrieveJobById(int id) {
        return jobPostingDao.getJobById(id);
    }

    @Override
    public int deleteJob(int id) {
        return jobPostingDao.deleteJobById(id);
    }

    @Override
    public int updateJob(JobPosting jobPosting) {
        return jobPostingDao.updateJob(jobPosting);
    }

    @Override
    public int createMultipleJobs(List<JobPosting> jobPostings) {
        return jobPostingDao.saveMultipleJobs(jobPostings);
    }
}
