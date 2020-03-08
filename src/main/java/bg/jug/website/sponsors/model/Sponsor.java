package bg.jug.website.sponsors.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import bg.jug.website.core.model.AbstractEntity;

@Entity
public class Sponsor extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 150)
    @Column(length = 150)
    private String name;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(length = 200)
    private String url;

    @Column(length = 100)
    @JsonbTransient
    private String type;

    @JsonbTransient
    @Lob
    private byte[] logo;

    public Sponsor() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
