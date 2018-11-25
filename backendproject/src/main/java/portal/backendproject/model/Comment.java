package portal.backendproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	@Lob
	private String comment;;
	@ManyToOne
	private Blog blog;
	@ManyToOne
	private User user;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
