package portal.backendproject.dao;

import java.util.List;

import portal.backendproject.model.Comment;

public interface CommentDao {

	public boolean addComment(Comment comment);
	public List<Comment> getComments(int blog_id);
	public List<Comment> getComments();
	public boolean Update(Comment comment);
	
}
