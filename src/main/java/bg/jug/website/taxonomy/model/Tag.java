package bg.jug.website.taxonomy.model;

import bg.jug.website.cms.model.Article;
import bg.jug.website.cms.model.Page;
import bg.jug.website.core.model.AbstractEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag extends AbstractEntity {

	@NotNull
	@Size(min=1, max=255)
	private String name;

	@JsonbTransient
	@ManyToMany(mappedBy = "tags")
	private Set<Page> pages = new HashSet<>();

	@JsonbTransient
	@ManyToMany(mappedBy = "tags")
	private Set<Article> articles = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}
