package forum.portalsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import portal.backendproject.dao.BlogDao;
import portal.backendproject.dao.CommentDao;
import portal.backendproject.dao.UserDao;
import portal.backendproject.model.Blog;
import portal.backendproject.model.Comment;
import portal.backendproject.model.Login;
import portal.backendproject.model.User;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private CommentDao commentDao;

	@PostMapping("/register")
	public User register(@RequestBody User user) {

		System.out.println(user.getName());

		if (userDao.registerUser(user)) {
			return user;
		} else {
			return null;
		}
	}

	@PostMapping("/login")
	public User login(@RequestBody Login login) {

		System.out.println(login.getEmail() + " " + login.getPassword());
		User userDetails = userDao.loginUser(login.getEmail(), login.getPassword());

		if (userDetails != null) {
			return userDetails;
		} else {
			return null;
		}

	}

	@PostMapping("/addPost")
	public String addBlog(@RequestBody Blog blog) {

		System.out.println(blog.getPost_desc());
		System.out.println(blog.getUser().getUser_id());
		if (blogDao.addPost(blog)) {
			return "post added ";
		} else {
			return "post not added";
		}
	}

	@GetMapping("/trainers")
	public List<User> getTrainerDetails() {
		return userDao.getTrainers();
	}

	@GetMapping("/activeuser/{id}")
	public boolean activeUser(@PathVariable("id") int id) {
		System.out.println(id);
		User user = userDao.getUserById(id);
		user.setStatus(true);
		if (userDao.updateUser(user)) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("/deactiveuser/{id}")
	public boolean deactiveUser(@PathVariable("id") int id) {
		System.out.println(id);
		User user = userDao.getUserById(id);
		user.setStatus(false);
		if (userDao.updateUser(user)) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("blogs")
	public List<Blog> getPosts() {
		System.out.println("get called");
		return blogDao.getAllPosts();
	}

	@GetMapping("myposts/{user_id}")
	public List<Blog> getMyPosts(@PathVariable("user_id") int user_id) {
		System.out.println("myposts get called");
		System.out.println(user_id);
		return blogDao.getAllPosts(user_id);
	}

	@PostMapping("comment")
	public String writeComment(@RequestBody Comment comment) {

		if(commentDao.addComment(comment)) { 
			return "comment added";
		}
		return "comment not added";
	}
	
	@GetMapping("getcomments/{blog_id}")
	private List<Comment> getComments(@PathVariable("blog_id")int blog_id){
		
		return commentDao.getComments(blog_id);
	}
}