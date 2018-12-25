package com.example.Rentit.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Rentit.hello.User;
import com.example.Rentit.hello.UserRepository;

@Controller //this class is the controller class.
@RequestMapping(path="/") //this means the url starts with /(after application path)
public class MainController {
	
	@Autowired //this means to get the bean called userRepository.automatically done by spring which is used to get the data
	private UserRepository userRepository;
	
	@PostMapping(path="/add") //map only post  requests.
	
	public  @ResponseBody String addNewUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email){
		
		//@responsebody is used to indicate that not a view but String is returned.
		//@Requestparam is used to indicate parameter from get or post requests.
		
		User n =new User();
		n.setFirstName(firstName);
		n.setLastName(lastName);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User>  getAllUsers(){
		//This returns a JSON or XML with the users.
		return userRepository.findAll();
	}
	
		
		
	}
	
	


