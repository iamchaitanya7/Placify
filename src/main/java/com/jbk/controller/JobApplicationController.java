package com.jbk.controller;

import com.jbk.entities.JobApplication;
import com.jbk.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobApplication")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    // POST /jobApplication/apply
    @PostMapping("/apply")
    public String applyForJob(@RequestBody JobApplication jobApplication) {
        int result = jobApplicationService.submitApplication(jobApplication);
        return switch (result) {
            case 1 -> "Application submitted successfully!";
            case 2 -> "Application already exists!";
            default -> "Error submitting application!";
        };
    }

    // PUT /jobApplication/updateStatus/{id}/{status}
    @PutMapping("/updateStatus/{id}/{status}")
    public String updateStatus(@PathVariable int id, @PathVariable String status) {
        int result = jobApplicationService.updateApplicationStatus(id, status);
        return switch (result) {
            case 1 -> "Application status updated successfully!";
            case 2 -> "Application not found!";
            default -> "Error updating application status!";
        };
    }

    // DELETE /jobApplication/withdrawApplication/{id}
    @DeleteMapping("/withdrawApplication/{id}")
    public String withdrawApplication(@PathVariable int id) {
        int result = jobApplicationService.withdrawApplication(id);
        return switch (result) {
            case 1 -> "Application withdrawn successfully!";
            case 2 -> "Application not found!";
            default -> "Error withdrawing application!";
        };
    }
}
