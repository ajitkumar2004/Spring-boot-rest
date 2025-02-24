package com.telusko.Spring_boot_rest.service;

import com.telusko.Spring_boot_rest.model.JobPost;
import com.telusko.Spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;



    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.findAll();


    }
    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);

    }


    public JobPost getAllJob(int postId) {
     return repo.findById(postId).orElseThrow();
    }
    public void addjob(JobPost job)
    {
        repo.save(job);
    }

    public void update(JobPost jobPost) {
        repo.save(jobPost);
    }
    public void delete(int id)
    {

    repo.deleteById(id);
    }
    public void update()
    {
        List<JobPost> jobs = new ArrayList<>(List.of(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React"))
                , new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis"))));
repo.saveAll(jobs);
    }


    public List<JobPost> serch(String keyword) {
   return  repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}