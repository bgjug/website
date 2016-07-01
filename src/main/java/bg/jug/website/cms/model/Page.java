package bg.jug.website.cms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import bg.jug.website.core.model.AbstractEntity;
import bg.jug.website.taxonomy.model.Tag;

@Entity
@XmlRootElement
public class Page extends AbstractEntity {
	
	@NotNull
	@Size(min=1, max=150)
	private String title;
	
	@NotNull
	@Size(min=1, max=1000)
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
