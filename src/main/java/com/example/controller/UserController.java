package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.User;
import com.example.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService  userService;
	@GetMapping("/sform")
	public String showForm(Model model)
	{
		User user=new User();
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("head", "Create User Form");
		return "form";
	}
	@PostMapping("/saveData")
	public String readForm(User user,Model model,RedirectAttributes redirectAttributes)
	{
		System.out.println("saveData "+user);
		Boolean b = userService.saveUser(user);
		if(b)
		{
			System.out.println("save data");
			redirectAttributes.addFlashAttribute("msg", "User is created successfully..");
			return "redirect:/sform";
			
		}
		else {
			System.out.println("save data");
			model.addAttribute("msg", "User Data is Updated successfully..");
			model.addAttribute("head", "Update User Data");
			return "form";
		}
		
	}
	@GetMapping("/view")
	public String showViewForm(Model model)
	{
		List<User>userList=userService.getAllUser();
		model.addAttribute("users", userList);
		return "view";
	}
	@GetMapping("/updateForm/{id}")
	public String editForm(@PathVariable("id") Integer id,Model model)
	{
		System.out.println("id="+id);
		User user=userService.getById(id);
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("head", "Update User Data");
		return"form";
	}
	@GetMapping("/deleteData/{id}")
	public String deleteData(@PathVariable("id") Integer id,Model model)
	{
		userService.deleteById(id);
		model.addAttribute("msg", "Record is successfuly deleted");
		return "forward:/view";	
	}
	@GetMapping("/updateAction")
	public String updateAction(@RequestParam("id") Integer id,@RequestParam("userAction") String userAction)
	{
		System.out.println( userAction);
		userService.updateAction(id, userAction);
		return "redirect:/view";
	}

}
