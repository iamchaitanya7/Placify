package com.jbk.controller;

import com.jbk.entities.JobPosting;
import com.jbk.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-postings")
public class JobPostingController {

    @Autowired
    JobPostingService jobPostingService;

    @PostMapping("/createJob")
    public String createJob(@RequestBody JobPosting jobPosting) {
        int result = jobPostingService.createJob(jobPosting);
        return result == 1 ? "Job created successfully!" : result == 2 ? "Error creating job!" : "Error occurred due to an exception!";
    }

    @GetMapping("/allJobs")
    public List<JobPosting> getAllJobs() {
        return jobPostingService.retrieveAllJobs();
    }

    @GetMapping("/retrieveJob/{id}")
    public JobPosting getJobById(@PathVariable int id) {
        return jobPostingService.retrieveJobById(id);
    }

    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable int id) {
        int result = jobPostingService.deleteJob (id);
        return result == 1 ? "Job deleted successfully!" : result == 2 ? "Error deleting Job!" : "Error occurred due to an exception!";
    }

    @PutMapping("/updateJob")
    public String updateJob(@RequestBody JobPosting jobPosting) {
        int result = jobPostingService.updateJob(jobPosting);
        return result == 1 ? "Job updated successfully!" : result == 2 ? "Error updating job!" : "Error occurred due to an exception!";
    }

    @PostMapping("/createMultipleJobs")
    public String createMultipleJobs(@RequestBody List<JobPosting> jobPostings) {
        int result = jobPostingService.createMultipleJobs(jobPostings);
        return result == 1 ? "Multiple Jobs created successfully!" : result == 2 ? "Error creating multiple jobs!" : "Error occurred due to an exception!";
    }
}
