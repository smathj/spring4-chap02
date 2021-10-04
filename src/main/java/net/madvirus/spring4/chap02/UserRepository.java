package net.madvirus.spring4.chap02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

	private Map<String, User> userMap = new HashMap<>();

	public User findUserById(String id) {
		return userMap.get(id);
	}
	
	
	// setter
	// setter가 리시트 타입이다, 따라서 
	// config.xml에서 property.list.ref로 하나씩 설정하였다.
	public void setUsers(List<User> users) {
		for (User u : users)
			userMap.put(u.getId(), u);
	}
}
