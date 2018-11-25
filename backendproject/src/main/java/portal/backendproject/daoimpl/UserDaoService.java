package portal.backendproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portal.backendproject.dao.UserDao;
import portal.backendproject.model.User;

@Component
@Transactional
public class UserDaoService implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User loginUser(String email, String password) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email and password=:password",User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			System.out.println(query.getSingleResult().getRole());
			 return query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User getUserById(int user_id) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where user_id=:user_id",User.class);
			query.setParameter("user_id", user_id);
			return query.getSingleResult();
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email",User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getTrainers() {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where role='trainer'",User.class);
             
			 return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateUserById(int user_id) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where user_id=:user_id",User.class);
			query.setParameter("user_id", user_id);
			User user=query.getSingleResult();
			user.setStatus(true);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
