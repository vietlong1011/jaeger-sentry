package com.example.democicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cicd.App2Application;
import java.util.List;


@SpringBootTest(classes = App2Application.class)
class App2ApplicationTests {

	App2ApplicationTests(){}

@Test
void contextLoads(){}


// 	@Autowired
// 	public UserRepository userRepository;

// 	public User user = new User();

// 	@Test
// 	void contextLoads() {
// 		List<User> uList = userRepository.findAll();
// 		uList.forEach(user -> {
// 			System.out.println(user.toString()); // In ra thông tin của mỗi user
// 		});
// 	}
// @SpringBootTest(classes = DemoCicdApplication.class)
// class DemoCicdApplicationTests {

// 	@Autowired
// 	private UserRepository userRepository;

// 	@Test
// 	void contextLoads() {
// 		List<User> userList = userRepository.findAll();
// 		for (User user : userList) {
// 			System.out.println(user); // In ra thông tin của mỗi user
// 		}
// 	}

// thu tao 1 ham return list xem

}
