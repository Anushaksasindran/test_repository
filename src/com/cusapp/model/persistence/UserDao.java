package com.cusapp.model.persistence;



import java.util.List;

public interface UserDao {
	public User findUser(String email,String password);
	public void addUser(User user);
	public List<User> getAllUsers();

}
