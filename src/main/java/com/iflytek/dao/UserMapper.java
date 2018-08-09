package com.iflytek.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iflytek.entity.User;

public interface UserMapper {

	/**
	 * 新增
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 更新
	 * @param user
	 */
	void updateUser(User user);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	
	/**
	 * 更具id删除
	 * @param id
	 */
	void deleteUser(int id);
	
	/**
	 * 查询
	 * @return
	 */
	List<User> getUserList();
	
	/**
	 * 修改密码
	 */
	void updateUserPwd(@Param("id")int id,@Param("password")String password);
	
	User checkUser(@Param("name")String name,@Param("password")String password);
	
	int checkName(String name);
}
