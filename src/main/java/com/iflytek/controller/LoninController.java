package com.iflytek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iflytek.entity.User;
import com.iflytek.service.UserService;

@Controller
@RequestMapping("/login")
public class LoninController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "login";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String toLogin(String name, String password, String image, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String text = (String) request.getSession().getAttribute("text");

		if (!text.equalsIgnoreCase(image)) {
			session.setAttribute("imageMess", "验证码输入错误!");
			return "login";
		}

		User user = userService.checkUser(name, password);
		if (user == null) {
			session.setAttribute("errorMessage", "用户名或者密码错误");
			return "login";
		}
		session.setAttribute("user", user);
		
		return "redirect:/login/index";
	}

	@RequestMapping("/index")
	public String toIndex() {
		
		return "index";
	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login/toLogin";
	}

}
