package bg.jug.website.model.cms;

import java.util.HashSet;
import java.util.Set;

import bg.jug.website.model.core.AbstractEntity;
import bg.jug.website.model.taxonomy.Tag;

public class Page extends AbstractEntity {
	
	private String title;
	
	private String content;
	
	private Set<Tag> tags = new HashSet<>();
	
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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
