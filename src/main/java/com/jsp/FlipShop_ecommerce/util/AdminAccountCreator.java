package com.jsp.FlipShop_ecommerce.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import com.jsp.FlipShop_ecommerce.entity.User;
import com.jsp.FlipShop_ecommerce.enums.UserRole;
import com.jsp.FlipShop_ecommerce.repo.userRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
@RequiredArgsConstructor
public class AdminAccountCreator implements CommandLineRunner {
private final  userRepo userRepo;
private final PasswordEncoder passwordEncoder;

@Value("${admin.email}")
private String adminemail;
@Value("${admin.password}")
private String adminpassword;
@Value("${admin.mobile}")
private Long adminmobile;
@Value("${admin.username}")
private String adminUserName;	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("admin Account creation started");
		if(userRepo.existsByEmail(adminemail)) {
			log.info("admin account already exists");
		}else {
			User user=new User();
			user.setActive(true);
			user.setMobile(adminmobile);
			user.setUsername(adminUserName);
			user.setPassword(passwordEncoder.encode(adminpassword));
			user.setRole(UserRole.ADMIN);
			userRepo.save(user);
			log.info("Admin Account creation sucess!"+adminUserName);
		}
	}
}