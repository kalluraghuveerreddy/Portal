package portal.backendproject.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portal.backendproject.dao.BlogDao;
import portal.backendproject.model.Blog;

@Component
@Transactional
public class BlogDaoService implements BlogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addPost(Blog blog) {

		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Blog getPost(int blog_id) {
		try {
			Query<Blog> query = sessionFactory.getCurrentSession().createQuery("from Blog where blog_id=:blog_id",
					Blog.class);
			query.setParameter("blog_id", blog_id);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Blog> getAllPosts(int user_id) {
		try {
			Query<Blog> query = sessionFactory.getCurrentSession().createQuery("from Blog where user_user_id=:user_id",
					Blog.class);
			query.setParameter("user_id", user_id);
			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Blog> getAllPosts() {
		try {
			Query<Blog> query = sessionFactory.getCurrentSession().createQuery("from Blog ",
					Blog.class);
	
			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

}
