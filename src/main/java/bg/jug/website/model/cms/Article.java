package bg.jug.website.model.cms;

import java.util.Date;

import bg.jug.website.model.user.User;

public class Article extends Page {
	private Date createdDate;
	private User author;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
}
