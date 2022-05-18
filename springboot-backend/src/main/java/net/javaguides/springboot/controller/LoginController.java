package net.javaguides.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Book;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	// get all books
	@PostMapping("/login/{login}")
	public ResponseEntity<Boolean> check(@PathVariable String login){
		Boolean result = false;
		
		String[] logins = login.split(",");
		
		List<User> users = userRepository.findAll();
		for (User u : users) {
			if(u.getLoginName().equals(logins[0]) && u.getPassword().equals(logins[1])) {
				result = true;
			}
		}
		return ResponseEntity.ok(result);
	}		
}
