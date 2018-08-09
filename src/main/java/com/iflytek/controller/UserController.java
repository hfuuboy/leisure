package com.iflytek.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iflytek.entity.User;
import com.iflytek.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 跳转到用户新增页面
	 * @return
	 */
	@RequestMapping(value = "/addUser")
	public String addUser() {

		return "userAdd";
	}

	/**
	 * 新增用户
	 * @param user：用户对象
	 * @return
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject saveUser(User user) {
		JSONObject jsonObject = new JSONObject();
		userService.addUser(user);
		jsonObject.put("status", "OK");
		return jsonObject;
	}
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value="/toUserList",method=RequestMethod.GET)
	public ModelAndView toUserList() {
		
		ModelAndView mv = new ModelAndView("userList");
		List<User> list = userService.getUserList();
		
		mv.addObject("list", list);
		
		return mv;
	}

	/**
	 * 跳转到更新页面
	 * @param id：用户id
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(String id) {
		
		ModelAndView mv =  new ModelAndView("updateUser");
		User user = userService.getUserById(Integer.parseInt(id));
		mv.addObject("user", user);
		
		return mv;
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public User updateUser(User user) {
		userService.updateUser(user);
		return user;
	}
	
	/**
	 * 删除用户
	 * @param id：用户id
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(String id) {
		userService.deleteUser(Integer.parseInt(id));
		return "redirect:/user/toUserList";
	}
	
	@RequestMapping("/checkName")
	@ResponseBody
	public Map<String, Object> toPassword(String name) {
		Map<String, Object> map = new HashMap<>();
		int count = userService.checkName(name);
		if(count > 0) {
			map.put("status", "error");
		}else {
			map.put("status", "OK");
		}
		return map;
	}
	
}
