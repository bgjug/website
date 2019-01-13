package bg.jug.website.cms.model;

import bg.jug.website.core.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Page extends AbstractEntity {

	@NotNull
	@Size(min=1, max=150)
	private String title;

	@NotNull
	@Size(min=1, max=100000)
	@Column(length = 100000)
	private String content;

// TODO for stage 2.
//	private Set<Tag> tags = new HashSet<>();
	
	private boolean published = false;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

}
