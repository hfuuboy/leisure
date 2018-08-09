package com.iflytek.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iflytek.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestService {
	
	@Autowired
	private UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testAddUser() {
		
		User user = new User();
		user.setName("lily");
		user. setPassword("lily123456");
		user.setEmail("lily@sina.com");
		user.setPhone("15201472510");
		user.setSex(0);
		userService.addUser(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(1);
//		user.setName("lily");
//		user. setPassword("lily123456");
//		user.setEmail("lily@sina.com");
//		user.setPhone("15201472510");
		user.setSex(1);
		userService.updateUser(user);
	}
	
	@Test
	public void testGetUserById() {
		User user = userService.getUserById(1);
		System.out.println(user.getName());
	}
	
	@Test
	public void testDeleteUser() {
		userService.deleteUser(2);
	}
	
	@Test
	public void testGetUserList() {
		List<User> list = userService.getUserList();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	}
	
	@Test
	@SuppressWarnings("resource")
	public void testDataSource() throws SQLException {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) act.getBean("dataSource");
		System.out.println(dataSource.getClass());
	}

}
