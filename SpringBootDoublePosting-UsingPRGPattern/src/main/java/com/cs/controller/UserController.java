package com.cs.controller;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs.model.User;

@Controller
public class UserController {

	private static org.slf4j.Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value={"/","/userAcc"},method=RequestMethod.GET)
	public String loadForm( Model mod) {
		
		mod.addAttribute("userModel", new User());
		mod.addAttribute("msg", "Form Submitted SuccessFully ");
		logger.info("Account SuccessFully Created()");
		return "login";
	}
	
	@RequestMapping(value="/userAcc", method=RequestMethod.POST)
	public  String getUserData(@ModelAttribute("userModel") User  user , Model mod) {
		logger.info("User Form Submitted ::"+user);

		return "redirect:/userAcc";
	}
	
}
