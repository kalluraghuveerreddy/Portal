package portal.backendproject.daoimpl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import portal.backendproject.dao.CommentDao;
import portal.backendproject.model.Comment;

@Component
@Transactional
public class CommentService implements CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addComment(Comment comment) {

		try {
			sessionFactory.getCurrentSession().save(comment);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Comment> getComments(int blog_id) {
		try {
			Query<Comment> query = sessionFactory.getCurrentSession()
					.createQuery("from Comment where blog_blog_id=:blog_id", Comment.class);
			query.setParameter("blog_id", blog_id);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Comment> getComments() {
		try {
			Query<Comment> query = sessionFactory.getCurrentSession()
					.createQuery("from Comment ", Comment.class);
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean Update(Comment comment) {
		try {
			sessionFactory.getCurrentSession().update(comment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
