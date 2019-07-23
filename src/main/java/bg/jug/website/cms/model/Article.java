package bg.jug.website.cms.model;

import bg.jug.website.core.model.AbstractEntity;
import bg.jug.website.taxonomy.model.Tag;
import bg.jug.website.user.model.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = Article.FIND_ALL, query = "SELECT a FROM Article a LEFT JOIN FETCH a.author ORDER BY a.createdDate DESC")
@NamedQuery(name = Article.FIND_BY_ID, query = "SELECT a FROM Article a LEFT JOIN FETCH a.author WHERE a.id = ?1")
@NamedQuery(name = Article.FIND_ALL_BY_TAG, query = "SELECT a FROM Article a JOIN a.tags t WHERE t.name = ?1")
public class Article extends AbstractEntity {

    public static final String FIND_ALL = "findAllArticles";
    public static final String FIND_BY_ID = "findArticleById";
    public static final String FIND_ALL_BY_TAG = "findAllArticlesByTag";

    @NotNull
    @Size(min=1, max=150)
    private String title;

    @NotNull
    @Size(min=1, max=100000)
    @Column(length = 100000)
    private String content;

    private boolean published = false;

//    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "article_tag",
                    joinColumns = @JoinColumn(name = "article_id"),
                    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
