package com.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Employee;
import com.library.entity.User;
import com.library.model.service.UserService;

@Controller
@Scope("session")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		return new ModelAndView("Login","command",new User());
	}
	
	@RequestMapping("/loginEmployee")
	public ModelAndView loginCheck(@ModelAttribute("command") User user/*, HttpSession session*/) {
		ModelAndView modelAndView = new ModelAndView();
		User usr = userService.loginUser(user);
		if (usr != null) {
			modelAndView.addObject("employee", usr); // request Scope
			session.setAttribute("employee", user);
			modelAndView.setViewName("Menu");
		} else {
			modelAndView.addObject("message", "Login Failed!");
			modelAndView.setViewName("Login");
		}
		return modelAndView;
	}
}
