package com.buy.product;

import com.buy.product.Object.User;
import com.buy.product.Repository.UserRepository;
import com.buy.product.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
class ProductApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Test
	void repositoryChkTest() {
		Optional<User> res = userRepository.findBySeq(1L);
		System.out.println("res = " + res.get().getName());
	}
	@Test
	void chekcLoginTest() {
		User user = new User();
		user.setName("jihuhwan");
		user.setPasswd("ahstmxj1!");
		String res = userService.CheckLogin(user);
		System.out.println(res);
	}
}
