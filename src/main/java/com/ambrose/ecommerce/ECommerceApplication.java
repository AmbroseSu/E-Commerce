package com.ambrose.ecommerce;

import com.ambrose.ecommerce.entities.User;
import com.ambrose.ecommerce.entities.enums.Role;
import com.ambrose.ecommerce.repository.UserRepository;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args)  {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	public void run(String...args) throws IOException {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFullname("admin");
			//user.setSecondname("admin");
			user.setRole(Role.ADMIN);
			user.setEnabled(true);
			user.setLogin("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}

	}

}
