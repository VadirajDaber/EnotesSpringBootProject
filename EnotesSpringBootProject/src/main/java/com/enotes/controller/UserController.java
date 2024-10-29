package com.enotes.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enotes.entity.User;
import com.enotes.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	@ModelAttribute
	public void getUser(Principal p, Model m) {
		
		String email = p.getName();
		User user = repository.findByEmail(email);
		m.addAttribute("user", user);
	}
	
	
	@GetMapping("/addNotes")
	public String addNotes() 
	{
		return "add_notes";
	}
	
	
	@GetMapping("/viewNotes")
	public String viewNotes() 
	{
		return "view_notes";
	}
	
	
	@GetMapping("/editNotes")
	public String editNotes() 
	{
		return "edit_notes";
	}
}
