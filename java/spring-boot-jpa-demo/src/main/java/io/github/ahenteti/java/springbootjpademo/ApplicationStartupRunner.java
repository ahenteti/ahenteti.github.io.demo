package io.github.ahenteti.java.springbootjpademo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.ahenteti.java.springbootjpademo.model.Car;
import io.github.ahenteti.java.springbootjpademo.model.User;
import io.github.ahenteti.java.springbootjpademo.repository.CarRepository;
import io.github.ahenteti.java.springbootjpademo.repository.UserRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired 
	private CarRepository carRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		Car car1 = new Car();
		Car car2 = new Car();
		car1.setId(1L);
		car1.setModel("model1");
		car1.setUser(user);
		car2.setId(2L);
		car2.setModel("model2");
		car2.setUser(user);
		user.setId(1L);
		user.setUsername("username");
		user.setCars(Arrays.asList(car1, car2));
		userRepository.save(user);
	}


}
