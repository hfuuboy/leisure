package com.iflytek.service;

import java.util.List;

import com.iflytek.entity.User;

public interface UserService {
	
	void addUser(User user);
	
	void updateUser(User user);
	
	User getUserById(int id);
	
	void deleteUser(int id);
	
	List<User> getUserList();
	
	void updateUserPwd(int id,String password);
	
	User checkUser(String name,String password);
	
	int checkName(String name);

}
