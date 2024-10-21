package com.enotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.enotes.entity.User;
import com.enotes.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		User newUser = userRepo.save(user);
		return newUser;
	}

	@Override
	public boolean existEmailCheck(String email) {
		
		return userRepo.existsByEmail(email);
	}

	public void removeSessionMessage() {
		
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}
}
