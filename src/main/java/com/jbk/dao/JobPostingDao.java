package com.jbk.dao;

import com.jbk.entities.JobPosting;
import java.util.List;

public interface JobPostingDao {
    int saveJob(JobPosting jobPosting);
    List<JobPosting> getAllJobs();
    JobPosting getJobById(int id);
    boolean deleteJobById(int id);
    boolean updateJob(JobPosting jobPosting);
    int saveMultipleJobs(List<JobPosting> jobPostings);
}
