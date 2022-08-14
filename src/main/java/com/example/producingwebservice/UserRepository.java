package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.User;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserRepository {
	private static final HashMap<BigInteger, User> users = new HashMap<>();

	@PostConstruct
	public void initData() {
		User arwa = new User();
		arwa.setName("Arwa");
		arwa.setAddress("Benha");
		arwa.setId(BigInteger.valueOf(1));


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
		Assert.notNull(id, "The users's id must not be null");
		return users.get(id);
	}

	public void addUser(User user) {
		users.put(user.getId(),user);
	}

	public List<User> findAllUsers() {
		List<User> ll=new ArrayList<User>();
		for(Map.Entry<BigInteger,User> u:users.entrySet()){
			ll.add(u.getValue());
		}
		System.out.print (ll+"ll");
		return ll;
	}

	public void deleteUser(BigInteger id) {
		users.remove(id);
	}

	public void updateUser(BigInteger id, User user) {
		users.put(id,user);
	}
}
