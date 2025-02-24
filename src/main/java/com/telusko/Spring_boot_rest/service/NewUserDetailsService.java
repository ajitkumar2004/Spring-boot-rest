package com.telusko.Spring_boot_rest.service;

import com.telusko.Spring_boot_rest.model.Details;
import com.telusko.Spring_boot_rest.model.Users;
import com.telusko.Spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class NewUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo user;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users users = user.findByusername(username);
if(users==null)
{
    System.out.println("error");
    throw new UsernameNotFoundException("user 404");
}
        return new Details(users) ;
    }
 BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Users saveuser(Users users)
    {
        users.setPassword(encoder.encode(users.getPassword()));
        return user.save(users);

    }


}
