package com.iflytek.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iflytek.dao.UserMapper;
import com.iflytek.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapper {
	
	@Autowired
	private UserMapper userMapper;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("lucy");
		user. setPassword("lucy123456");
		user.setEmail("lucy@sina.com");
		user.setPhone("15201472510");
		user.setSex(0);
		userMapper.addUser(user);
	}

}