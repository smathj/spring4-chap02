package net.madvirus.spring4.chap02.conf;

import java.util.Arrays;

import net.madvirus.spring4.chap02.AuthFailLogger;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.User;
import net.madvirus.spring4.chap02.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 해당 클래스를 스프링 설정으로 사용하겠다는 선언
public class Config {

	@Bean		// 메서드의 리턴 값을 빈 객체로 사용하겠다 선언
	public User user1() {
		return new User("bkchoi", "1234");	// 객체를 생성해서 리턴
	}

	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}

	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;					// 객체 리턴
	}

	@Bean
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
	}

	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}

	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}

}
