package com.example.demo.controller;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Uuser;
import com.example.demo.repo.UserRepo;

import oracle.net.aso.i;

@Controller
public class signupcontroller {
	@Autowired
	UserRepo repo;
	@RequestMapping("/")
public String index()
{
	return "index.jsp";
	
}
	@RequestMapping("/signup")
	public String signup(Uuser user)
	{ 
		
		repo.save(user);
		System.out.println("USER SAVED");
		return "signup.jsp";
	}
	@RequestMapping("/login")
	public String login(Uuser user)
	{ 
		

		return "login.jsp";
	}
	@RequestMapping( value = "/logincheck",method = RequestMethod.POST)
	public String logincheck(@RequestParam("id") String id,@RequestParam("password")String password ,Uuser user,ModelMap mod)
	{   try {
		int id1 = user.getId();
		//String passwordfromobject = user.getPassword();
		//System.out.println(idfromobject+"   "+passwordfromobject);
		//int z=Integer.parseInt(id);
		Optional<Uuser> findById = repo.findById(id1);
		Uuser user2 = findById.get();
		String password2 = user2.getPassword();
		if(password.equals(password2))
		{
		return "home.jsp";
		}
		else {
mod.addAttribute("msg", "invalid username or password");
	return "login.jsp";
	}}
	catch (Exception e) {

mod.addAttribute("msg", "invalid username or password");
	return "login.jsp";	}
	}
//View all users
	@RequestMapping("/showDetail")
	public String viewAll(Uuser user,ModelMap mymap)
	{ 
		Iterable<Uuser> findAll = repo.findAll();
		
		mymap.addAttribute("details", findAll);
for (Uuser uuser : findAll) {
	System.out.println(uuser);
}
		return "displayDetails.jsp";
	}
	}


