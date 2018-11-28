package portal.backendproject.dao;

import java.util.List;

import portal.backendproject.model.User;

public interface UserDao {

	public boolean registerUser(User user);
	public User loginUser(String email,String password);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUserById(int id);
	public User getUserById(int user_id);
	public User getUserByEmail(String email);
	public List<User> getTrainers();
	public List<User> getStudents();
}
