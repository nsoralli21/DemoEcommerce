package com.demoEcommerce.controller;


import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoEcommerce.dao.User;

@Controller
public class LoginController {

	private static final int ResponseEntity = 0;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        /*return "login.html";*/
		return "login.html";
    }
	
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String showDashboardPage(ModelMap model){
        return "Dashboard.html";
    }
	@RequestMapping(value="/summary", method = RequestMethod.GET)
    public String showSummaryPage(ModelMap model){
        return "Summary.html";
    }

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<String> userLogin(ModelMap model,@RequestBody User requestBody ,HttpSession hses) {
		
		if(requestBody.getUsername().equals("Admin")&&requestBody.getPassword().equals("Admin@123")) {
			hses.setAttribute("username", "Admin");
			return new ResponseEntity<String>("Login Success", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "login";
	}

}
