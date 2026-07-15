package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import com.example.demo.serviceimpl.*;
import com.example.demo.entity.User;
import com.example.demo.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl service;
	
	@GetMapping("/register")
	public String registerpage()
	{
		return "Registers";
	}
	
	@PostMapping("/register")
	public String register(User user)
	{
		service.register(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
    	

        User user = service.login(email, password);

        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
           return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid Email or Password");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
   public String logout(HttpSession session) 
   {
    	session.invalidate();
    	return "redirect:/login";
   }
}

	
