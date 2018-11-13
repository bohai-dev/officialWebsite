package com.cfun.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {

	/**
	 * 
	 * @return 登录页
	 */
	@RequestMapping("/login")
	public String login()
	{ 
		return "login";
	  	
	}
	@RequestMapping("/admin")
	public String home()
	{ 
		return "home";
	  	
	}
	@RequestMapping("/stripe")
	public  String stripe(){

		return "stripepaytest";
	}

	/**
	 * 登录错误，重新返回登录页
	 * @param model
	 * @return   
	 */
	@RequestMapping("/loginError")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
	    return "login";
	}
}
