package com.rest.singletons;

import java.util.HashMap;
import java.util.Map;

import com.rest.persistance.SqliteUtils;
import com.rest.vo.User;

public class Storeroom {
	private static Storeroom instance = null;
	private Map<String, User> users = new HashMap<>();

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	private Storeroom() {
	}

	public void addUser(User user) {
		this.users.put(user.getEmailAddress(), user);
//		SqliteUtils.getInstance().saveUser(user);

	}

	public static Storeroom getStoreroom() {
		if (instance == null)
			instance = new Storeroom();
		return instance;
	}

}
