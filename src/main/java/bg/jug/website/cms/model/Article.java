package bg.jug.website.cms.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bg.jug.website.core.model.AbstractEntity;
import bg.jug.website.user.model.User;

@Entity
@NamedQuery(name = Article.FIND_ALL, query = "SELECT a FROM Article a JOIN FETCH a.author ORDER BY a.createdDate DESC")
@NamedQuery(name = Article.FIND_BY_ID, query = "SELECT a FROM Article a JOIN FETCH a.author WHERE a.id = ?1")
public class Article extends AbstractEntity {

    public static final String FIND_ALL = "findAllArticles";
    public static final String FIND_BY_ID = "findArticleById";

    @NotNull
    @Size(min=1, max=150)
    private String title;

    @NotNull
    @Size(min=1, max=100000)
    @Column(length = 100000)
    private String content;

    private boolean published = false;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

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
