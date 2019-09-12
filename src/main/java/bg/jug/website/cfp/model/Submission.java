package bg.jug.website.cfp.model;

import bg.jug.website.core.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Submission extends AbstractEntity {
    @NotNull
    @Size(min=1, max=150)
    private String name;

    @NotNull
    @Size(min=1, max=150)
    private String email;

    @NotNull
    @Size(min=1, max=150)
    private String title;

    @NotNull
    @Size(min=1, max=100000)
    @Column(length = 100000)
    private String details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
