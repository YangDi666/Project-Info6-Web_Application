package tse.info6.services;

import tse.info6.dataModels.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
