package com.jbk.dao;

import com.jbk.entities.JobPosting;
import java.util.List;

public interface JobPostingDao {
    int saveJob(JobPosting jobPosting);
    List<JobPosting> getAllJobs();
    JobPosting getJobById(int id);
    int deleteJobById(int id);
    int updateJob(JobPosting jobPosting);
    int saveMultipleJobs(List<JobPosting> jobPostings);
}
