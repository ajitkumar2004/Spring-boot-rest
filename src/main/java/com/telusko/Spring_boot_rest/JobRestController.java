package com.telusko.Spring_boot_rest;


import com.telusko.Spring_boot_rest.model.JobPost;
import com.telusko.Spring_boot_rest.service.JobService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:3000")//to accept request of the 3000 react to use this as backend
public class JobRestController {
  @Autowired
    private JobService service;
  @GetMapping("jobPosts")
  @ResponseBody
  public List<JobPost>  getAllJobs()
  {
      return service.getAllJobs();
  }
  @GetMapping("jobPost/{postId}")
  public JobPost  getAllJob(@PathVariable int postId)
  {
    return service.getAllJob(postId);
  }
  @PostMapping("jobPost")
  public void addjob(@RequestBody JobPost jobPost)
  {

   service.addjob(jobPost);
  }
  @PutMapping("jobPost")
  public JobPost updatejob(@RequestBody JobPost jobPost)
  {
    service.update(jobPost);
    return service.getAllJob(jobPost.getPostId());
  }
  @DeleteMapping("jobPost/{postId}")
  public void delete(@PathVariable int postId)
  {
    service.delete(postId);
  }
  @GetMapping("add")
  public void update()
  {
    service.update();
  }
  @GetMapping("jobPosts/keyword/{keyword}")
  public List<JobPost> searchByKeyWord(@PathVariable String keyword)
  {
    return service.serch(keyword);
  }





}
