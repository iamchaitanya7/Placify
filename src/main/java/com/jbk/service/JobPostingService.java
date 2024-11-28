package com.jbk.service;

import com.jbk.entities.JobPosting;

import java.util.List;

public interface JobPostingService {
    int createJob(JobPosting jobPosting);
    List<JobPosting> retrieveAllJobs();
    JobPosting retrieveJobById(int id);
    int deleteJob(int id);
    int updateJob(JobPosting jobPosting);
    int createMultipleJobs(List<JobPosting> jobPostings);
}