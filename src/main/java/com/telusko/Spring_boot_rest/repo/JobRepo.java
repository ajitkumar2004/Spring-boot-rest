package com.telusko.Spring_boot_rest.repo;

import com.telusko.Spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
public List<JobPost> findByPostProfileContainingOrPostDescContaining(String a,String b);
}
