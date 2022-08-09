package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.User;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserRepository {
	private static final Map<BigInteger, User> users = new HashMap<>();

	@PostConstruct
	public void initData() {
		User arwa = new User();
		arwa.setName("Arwa");
		arwa.setAddress("Benha");
		arwa.setId(BigInteger.valueOf(2));


		users.put(arwa.getId(), arwa);

		User toka = new User();
		toka.setName("Toka");
		toka.setAddress("Benha");
		toka.setId(BigInteger.valueOf(2));


		users.put(toka.getId(), toka);

		User ahmed = new User();
		ahmed.setName("Ahmed");
		ahmed.setAddress("Benha");
		ahmed.setId(BigInteger.valueOf(3));


		users.put(ahmed.getId(), ahmed);
	}

	public User findUser(BigInteger id) {
		Assert.notNull(id, "The users's name must not be null");
		return users.get(id);
	}

	public void addUser(User user) {
		users.put(user.getId(),user);
	}
}
