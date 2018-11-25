package portal.backendproject.dao;

import java.util.List;

import portal.backendproject.model.Blog;

public interface BlogDao {
	
	public boolean addPost(Blog blog);
	public Blog getPost(int blog_id);
	public List<Blog> getAllPosts(int user_id);
	public List<Blog> getAllPosts();

}
