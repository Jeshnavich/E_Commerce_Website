package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepository repo;

    @Override
    public User register(User user) {
    	// TODO Auto-generated method stub
    	return repo.save(user);
        
    }

    public User login(String email, String password) {

    	User user=repo.findByemail(email);
    	if(user!=null&&user.getPassword().equals(password)) {
    		return user;
    	}
    		return null;
    }
}