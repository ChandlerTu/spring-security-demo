package com.chandlertu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInitializer {

	@Autowired
	private UserRepository userRepository;

	@Test
	@WithMockUser(roles = { "ADMIN" })
	public void initialize() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		userRepository.save(new User("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
		userRepository.save(new User("security", passwordEncoder.encode("security"), "ROLE_SECURITY"));
		userRepository.save(new User("audit", passwordEncoder.encode("audit"), "ROLE_AUDIT"));
	}

}
