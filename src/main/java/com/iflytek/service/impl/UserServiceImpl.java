package com.iflytek.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.dao.UserMapper;
import com.iflytek.entity.User;
import com.iflytek.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public User getUserById(int id) {
		User user = userMapper.getUserById(id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public List<User> getUserList() {
		List<User> list = userMapper.getUserList();
		return list;
	}

	@Override
	public void updateUserPwd(int id, String password) {
		userMapper.updateUserPwd(id, password);
	}

	@Override
	public User checkUser(String name, String password) {
		User user = userMapper.checkUser(name, password);
		return user;
	}

	@Override
	public int checkName(String name) {
		int count = userMapper.checkName(name);
		return count;
	}
	
	

}
