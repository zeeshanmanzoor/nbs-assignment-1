package com.learning.java.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.java.model.User;
import com.learning.java.service.UserService;

@Controller
public class MainController {
	
	@Autowired(required=true)
	private UserService userService;

	@GetMapping
	public String getResitration(Map<String, Object> model) {
		User user = new User();
		model.put("userForm", user);
		return "register";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
		
		boolean error = false;
		
		System.out.print(user);
		if(user.getFirstName().isEmpty()) {
			bindingResult.reject("firstName", "this is error");
			error = true;
		}
		if(error) {
			return "register";
		}
		else { 
			userService.addUser(user);
			return "redirect:users";
		}	
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String listPersonsList(Model model) {
		model.addAttribute("userList", this.userService.listUsers());
		return "users";
	}
	
	@RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("userForm", this.userService.getUserById(id));
        return "edituser";
    }
	
	@RequestMapping(value="edit/edituser", method=RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") User user, BindingResult bindingResult){

		boolean error = false;
		
		if(user.getFirstName().isEmpty()) {
			bindingResult.reject("firstName", "error.firstName");
			error = true;
		}
		if(user.getLastName().isEmpty()) {
			bindingResult.reject("lastName", "error.lastName");
			error = true;
		}
		if(user.getEmail().isEmpty()) {
			bindingResult.reject("email", "error.email");
			error = true;
		}
		if(error) {
			return "edituser";
		}
		else {
 			this.userService.updateUser(user);
			return "redirect:/users";
		}
    }
}
