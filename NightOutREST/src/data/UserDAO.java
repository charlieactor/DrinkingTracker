package data;

import java.util.List;

import entities.User;

public interface UserDAO {
	
	public List<User> index();
	public User show(int id);
	public User create(User user);
	public User update(int id, User user);
	public boolean delete(int id);
	
}
