package com.placementprep.backend.service;

import com.placementprep.backend.entity.Job;
import com.placementprep.backend.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Create Job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // Update Job
    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = getJobById(id);

        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setPackageOffered(updatedJob.getPackageOffered());
        existingJob.setEligibilityCgpa(updatedJob.getEligibilityCgpa());
        existingJob.setLastDateToApply(updatedJob.getLastDateToApply());
        existingJob.setCompany(updatedJob.getCompany());

        return jobRepository.save(existingJob);
    }

    // Delete Job
    public void deleteJob(Long id) {

        Job existingJob = getJobById(id);

        jobRepository.delete(existingJob);
    }
}