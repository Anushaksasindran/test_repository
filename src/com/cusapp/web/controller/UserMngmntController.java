package com.cusapp.web.controller;



	import javax.annotation.PostConstruct;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;
	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

import com.cusapp.model.persistence.User;
import com.cusapp.model.persistence.UserNotFoundEx;
import com.cusapp.model.service.UserService;

	

	@Controller
	public class UserMngmntController {

		@Autowired
		private UserService userService;

		

		// @PostConstruct
		public void init() {
			userService.addUser(new User("anusha", "anu@anu.com", "admin", "anu123",true));
			userService.addUser(new User("sreena", "sreena@sreena.com", "mgr", "sreena123",true));
			userService.addUser(new User("alna", "alna@alna.com","emp", "elna123", true));
		}

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String home() {
			return "redirect:login";
		}

		@RequestMapping(value = "login")
		public String loginGet(HttpServletRequest req, ModelMap map) {
			map.addAttribute("userbean", new UserFormBean());
			map.addAttribute("error", req.getParameter("error"));
			return "login";
		}
		
		

		@RequestMapping(value = "logout")
		public String logout(ModelMap map) {
			map.addAttribute("userbean", new UserFormBean());
			map.addAttribute("message", "you are successfully logged out!");
			return "login";
		}

		@RequestMapping(value = "login", method = RequestMethod.POST)
		public String loginPost(HttpServletRequest req,
				@Valid @ModelAttribute(value = "userbean") UserFormBean userbean,
				BindingResult bindingResult) {

			User user = null;
			if (bindingResult.hasErrors()) {
				return "login";
			} else {
				try {
					user = userService.findUser(userbean.getEmail(),
							userbean.getPassword());
				} catch (UserNotFoundEx e) {
					return "redirect:login?error=login failed";
				}
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("user", user);
			}
			return "redirect:allcustomers";

		}

	}



