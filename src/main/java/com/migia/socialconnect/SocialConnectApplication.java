package com.migia.socialconnect;

import com.migia.socialconnect.model.User;
import com.migia.socialconnect.repository.UserRepository;
import com.migia.socialconnect.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;

@SpringBootApplication
public class SocialConnectApplication implements CommandLineRunner {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SocialConnectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User newUser = new User("Stephen", "stephen", "stephen@gmail.com", Role.ADMIN);
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		userRepository.save(newUser);*/
	}
}
