package com.telusko.Spring_boot_rest.repo;

import com.telusko.Spring_boot_rest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
 public Users findByusername(String username);
}
